package com.expertsoft.csv.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.expertsoft.csv.dao.ContactDao;
import com.expertsoft.csv.dao.ContactDaoImpl;
import com.expertsoft.csv.entity.Contact;
import com.expertsoft.csv.service.MimeType;
import com.expertsoft.csv.service.ReadCSV;

@WebServlet("/MainServlet")
@MultipartConfig()
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 3450601415542762362L;
	private static final String SUCCESS_MESSAGE = "File successfully downloaded.";
	private static final String ERROR_MESSAGE = "Incorrect file.";
	private static final String MAIN_PAGE_JSP = "/WEB-INF/pages/main.jsp";
	private static final String ADD_CSV_PAGE_JSP = "/WEB-INF/pages/addCsv.jsp";
	private static final String LIST_PAGE_JSP = "/WEB-INF/pages/list.jsp";
	private static final String ERROR_PAGE_JSP = "/WEB-INF/pages/error.jsp";
	private static final Logger logger = Logger.getLogger(ControllerServlet.class); 
	private ReadCSV readCvs = new ReadCSV(); 
    private ContactDao contDao = new ContactDaoImpl(); 

    public ControllerServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		final String testString = " 1 ";
		final String testString2 = " 2 ";
		final String testString3 = " 3 ";
		switch (action) {
		case "homePage":
			request.getRequestDispatcher(MAIN_PAGE_JSP).forward(request, response);
			break;
		case "addCsvPage":
			request.getRequestDispatcher(ADD_CSV_PAGE_JSP).forward(request, response);
			break;
		case "showListPage":
			listPage(request);
			request.getRequestDispatcher(LIST_PAGE_JSP).forward(request, response);
			break;
		default:
			response.sendRedirect(ERROR_PAGE_JSP);
			break;
		}
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("uploadCsv")){
			cvsPage(request);
			request.getRequestDispatcher(ADD_CSV_PAGE_JSP).forward(request, response);
		}
	}

	private void cvsPage(HttpServletRequest request){
		request.setAttribute("info", ERROR_MESSAGE);
		try {
			for (Part part : request.getParts()) {
				if (validateFile(part)) {
					request.setAttribute("info", SUCCESS_MESSAGE);
					Collection<String> headers = part.getHeaders("content-disposition");
					if (headers == null) continue;
					List<Contact> temp = readCvs.getContactListFromCVS(part.getInputStream());
					for (Contact contact : temp) {
						contDao.saveContacts(contact);
					}
				}
			}
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean validateFile(Part part){
		if(MimeType.getMimeTypes().contains(part.getContentType()) 	){
			logger.debug("file content type: " + part.getContentType());
			return true;	
		}else{
			logger.debug("file content type: incorrect");
			return false;
		}
		
	}
	
	private void listPage(HttpServletRequest request){
		int page = 1;
		int recordsPerPage = 10;
		String order = "";
		String field = "";
		if(request.getParameter("order") != null) order = request.getParameter("order");
		if(request.getParameter("field") != null) field = request.getParameter("field");
		if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
		
		try {
			request.setAttribute("contactList", contDao.selectAll((page-1)*recordsPerPage, recordsPerPage, order, field));
			int noOfRecords = contDao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("noOfPages", noOfPages);
		    request.setAttribute("currentPage", page);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
