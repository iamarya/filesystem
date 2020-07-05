<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Search File System</h1>
	</div>
	<div class="container" style="text-align: center; width: 50%">
	
		<form:form method="POST" action="/search" modelAttribute="search"
			id="search" class="form-inline">
			<form:input path="searchString" class="form-control mr-sm-2"
				style="width:80%" />
			<button type="submit" class="btn btn-primary mr-sm-2"
				id="searchsubmit" style="width: 15%">Search</button>
			<form:errors path="searchString" cssClass="alert-danger" />
		</form:form>
		<div class="container" style="text-align: center">
			<div class="container" style="text-align: left">
				<ul class="list-group list-group-flush">
					<c:forEach var="entry" items="${result}">
						<li class="list-group-item">${entry}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>