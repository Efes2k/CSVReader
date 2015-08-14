<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">

<title>List</title>
</head>
<body>
    
	<div class="allContent" >
		<c:import url="header.jsp"></c:import>
		<div class="containerAll" >
			<div class="container">
				<div class="searchResutlContainer">
					

		<div class="panel panel-primary" style="margin-top:50px;">
			 <div class="panel-heading">
    	     	<h3 class="panel-title">Contacts</h3>
  		     </div>
  
  			<div class="panel-body">
					<table class="table table-striped" data-sortable="true">
						<thead>
							<tr>
								<th data-sortable="true"  width="20%">
								<i class="glyphicon glyphicon-info-sign"></i>Login
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=asc&field=login">
									<i class="glyphicon glyphicon-chevron-up"></i>
								</a>
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=desc&field=login">
									<i class="glyphicon glyphicon-chevron-down"></i>
								</a>
								</th>
								<th data-sortable="true" width="20%"><i class="glyphicon glyphicon-user"></i>Name
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=asc&field=name">
									<i class="glyphicon glyphicon-chevron-up"></i>
								</a>
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=desc&field=name">
									<i class="glyphicon glyphicon-chevron-down"></i>
								</a>
								</th>
								<th data-sortable="true" width="20%"><i class="glyphicon glyphicon-user"></i>Surname
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=asc&field=surname">
									<i class="glyphicon glyphicon-chevron-up"></i>
								</a>
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=desc&field=surname">
									<i class="glyphicon glyphicon-chevron-down"></i>
								</a>
								</th>
								<th data-sortable="true" width="20%"><i class="glyphicon glyphicon-envelope"></i>Email
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=asc&field=email">
									<i class="glyphicon glyphicon-chevron-up"></i>
								</a>
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=desc&field=email">
									<i class="glyphicon glyphicon-chevron-down"></i>
								</a>
								</th>
								<th  width="20%"><i class="glyphicon glyphicon-phone"></i>Phone
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=asc&field=phone_number">
									<i class="glyphicon glyphicon-chevron-up"></i>
								</a>
								<a href="${pageContext.request.contextPath}/controller?action=showListPage&page=1&order=desc&field=phone_number">
									<i class="glyphicon glyphicon-chevron-down"></i>
								</a>
								</th>
							</tr>
						</thead>
						
						<tbody id="searchResult">
							<c:forEach var="i" items="${contactList}">
								<tr>
									<th>
									 	${i.login}<br/>
									</th>
									<th>
										${i.name}
									</th>
									<th>
										${i.surname}
										</th>
									<th>
										${i.email}
									</th>
									<th>
										${i.phoneNumber}
									</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
						<div class="row">
							<div class="col-md-offset-4 col-md-8">
							<ul class="pagination">
								<c:url	value="/controller?action=showListPage&page=${currentPage - 1}"	var="urlShowListMinus"></c:url>
								<c:if test="${currentPage != 1}">

									<li><a href="${urlShowListMinus}">Previous</a></li>
								</c:if>

								<c:forEach begin="1" end="${noOfPages}" var="i">
									<c:choose>
										<c:when test="${currentPage eq i}">
											<li></li>
										</c:when>
										<c:otherwise>
											<c:url value="/controller?action=showListPage&page=${i}"
												var="urlShowList"></c:url>
											<li><a href="${urlShowList}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<%--For displaying Next link --%>
								<c:if test="${currentPage lt noOfPages}">
									<c:url
										value="/controller?action=showListPage&page=${currentPage + 1}"
										var="urlShowListPlus"></c:url>
									<li><a href="${urlShowListPlus}">Next</a></li>
								</c:if>
							</ul>
							</div>
						</div>
					
					
							
						</div>
				   </div>
				</div>
			</div>
		
		</div>
	</div>
	
	<c:import url="footer.jsp"></c:import>

</body>
</html>