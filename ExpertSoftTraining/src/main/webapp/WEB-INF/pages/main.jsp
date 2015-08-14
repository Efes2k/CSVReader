<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">

<title>Main Page</title>
</head>
<body>

<c:url value="/controller?action=addCsvPage" var="urlAddCsv"></c:url>
<c:url value="/controller?action=showListPage" var="urlShowList"></c:url>

	<div class="allContent">
		<c:import url="header.jsp"></c:import>
		<div class="containerAll">
			<div class="container">
				<div class="searchResutlContainer">
					<div class="row">
						<div class="col-md-offset-4 col-md-8"></div>

					</div>
					<div class="row">
						<div class="col-md-offset-1 col-md-5">
							Press here to download new contacts:	
						</div>
						<div class="col-md-offset-1 col-md-5">
							Press here to view contacts
						</div>

					</div>
					<div class="row">
						<div class="col-md-offset-2 col-md-4">
							<a href="${urlAddCsv}" class="btn btn-primary dropdown-toggle">Add CSV</a>
						</div>
						<div class="col-md-offset-2 col-md-4">
							<a href="${urlShowList}" class="btn btn-primary dropdown-toggle">Show List</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>