<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/registercss.css"/>"
	rel="stylesheet" type="text/css">
<title>Registration Student</title>
</head>
<body>

	<div class="container mt-5 p-2">
		<div class="row">
			<div class="col-md-6 offset-md-3 py-2 px-2">
				<h1 class="text-center mt-2">Create Account Student</h1>
				<form action="handle-register-student" method="post">

					<div class="form-group ">
						<label for="email">First Name</label> <input type="text"
							class="form-control " placeholder="firstname" name="firstName"
							id="firstname" required>
					</div>

					<div class="form-group">
						<label for="email">Last Name</label> <input type="text"
							class="form-control" placeholder="lastname" name="lastName"
							id="lastname" required>
					</div>

					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" placeholder="email" name="email" id="email"
							required>
					</div>

					
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}"
							class="btn btn-danger">Back</a>
						<button type="submit" class="btn btn-warning">Create</button>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>