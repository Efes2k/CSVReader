package com.expertsoft.csv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.expertsoft.csv.entity.Contact;

public class ContactDaoImpl implements ContactDao {
	private final static String SQL_INSERT = "INSERT INTO contacts(login,name,surname,email,phone_number) VALUES(?,?,?,?,?)";
	private final static String SQL_UPDATE = "UPDATE contacts set login = ? , name = ? , surname = ? , email = ? , phone_number = ? WHERE id = ?";
	private final static String SQL_IS_EXIST = "SELECT * FROM contacts WHERE login = ?";
	private final static String SQL_SELECT_ALL = "SELECT SQL_CALC_FOUND_ROWS * FROM contacts";
	
	private int noOfRecords;
	private String order;
	private String field;
	final static Logger logger = Logger.getLogger(ContactDaoImpl.class);
	
	public ContactDaoImpl() {
		this.order = "asc";
		this.field = "login";
	}
	
	@Override
	public void saveContacts(Contact contact)  {
		int existingUserId = isExist(contact.getLogin()); 
		if (existingUserId == 0) saveNewContact(contact);
		else updateContact(contact, existingUserId);
	}
	
	private void saveNewContact(Contact contact){
		try (Connection conn = ConnectorDB.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT);) {
				ps.setString(1, contact.getLogin());
				ps.setString(2, contact.getName());
				ps.setString(3, contact.getSurname());
				ps.setString(4, contact.getEmail());
				ps.setInt(5, contact.getPhoneNumber());
				ps.executeUpdate();
				logger.info(contact.getLogin() + " successfully saved.");
			} catch (SQLException e) {
				logger.error("SQLException in saveNewContact()" );
				e.printStackTrace();
			}
	}
	
	private void updateContact(Contact contact,int id){
		try (Connection conn = ConnectorDB.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);) {
				ps.setString(1, contact.getLogin());
				ps.setString(2, contact.getName());
				ps.setString(3, contact.getSurname());
				ps.setString(4, contact.getEmail());
				ps.setInt(5, contact.getPhoneNumber());
				ps.setInt(6, id);
				ps.executeUpdate();
				logger.info(contact.getLogin() + " successfully updated.");
			} catch (SQLException e) {
				logger.error("SQLException in updateContact()" );
				e.printStackTrace();
			}
	}

	private int isExist(String login) {
		int existingUserId = 0;
		try (Connection conn = ConnectorDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_IS_EXIST);) {
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			logger.debug("finding user with login: "+ login);
			while (rs.next()) existingUserId = rs.getInt(1);
		} catch (SQLException e) {
			logger.error("SQLException in isExist()");
			e.printStackTrace();
		}
		return existingUserId;
	}

	@Override
	public List<Contact> selectAll(int offset, int noOfRecords, String order, String field) {
		String query = "";
		query += SQL_SELECT_ALL;
		if(order != "" && field != ""){
			setOrder(order);
			setField(field);
		}
		query += " ORDER BY " + getField() + " " + getOrder();
		query += " LIMIT " + offset + ", " + noOfRecords;
		
		logger.debug("execute query:"+ query);
		ResultSet rs = null;
		List<Contact> result = new ArrayList<Contact>();
				try(Connection conn = ConnectorDB.getConnection();
					PreparedStatement ps = conn.prepareStatement(query);
					
						){
					rs = ps.executeQuery();
					while(rs.next()){
						String login = rs.getString(2);
						String name = rs.getString(3);
						String surname = rs.getString(4);
						String email = rs.getString(5);
						int phoneNumber = rs.getInt(6);
						Contact cont = new Contact(login,name,surname,email,phoneNumber);
						result.add(cont);
					}
					
					rs.close();
					rs = ps.executeQuery("SELECT FOUND_ROWS()");
					if(rs.next())
						this.noOfRecords = rs.getInt(1);
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				finally{
					if(rs != null)
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					logger.debug("size of saving entities: " + result.size());
				}
				return result;
		
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
