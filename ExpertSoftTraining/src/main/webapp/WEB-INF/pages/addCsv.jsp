<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">

<title>Add contacts</title>
</head>
<body>
	<c:url value="/controller?action=uploadCsv" var="urlUploadFile"></c:url>
	<div class="allContent">
		<c:import url="header.jsp"></c:import>
		<div class="containerAll">
			<div class="container">
				<div class="searchResutlContainer">

					<div class="control-group">
						<div class="row">
							<div class="col-md-offset-2 col-md-4">
								<form method="POST" action="${urlUploadFile}" enctype="multipart/form-data">
							<input type="file" id="uploadFile" name="file" size="60" /><br />
							<br /> <button class="btn btn-primary" type="submit" >Import</button> 
						</form>
							</div>
							<div class="col-md-offset-2 col-md-4">
								<h1>${info}</h1>
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