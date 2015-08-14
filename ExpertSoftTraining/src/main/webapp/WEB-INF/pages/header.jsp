<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/controller?action=homePage" var="urlHome"></c:url>
<c:url value="/controller?action=addCsvPage" var="urlAddCsv"></c:url>
<c:url value="/controller?action=showListPage" var="urlShowList"></c:url>

<div class="container">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
			
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-collapse-3">
				<ul class="nav navbar-nav " >
					
					<li><a href="${urlHome}"><i class="glyphicon glyphicon-home"></i>Home</a></li>
					<li><a href="${urlAddCsv}"><i class="glyphicon glyphicon-pencil"></i>Add CSV</a></li>
					<li><a href="${urlShowList}"><i class="glyphicon glyphicon-th-list"></i>Show list</a></li>
					
				</ul>

			</div>
		</div>
	</nav>
</div>


