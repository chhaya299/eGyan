<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@include file="./base.jsp"%>
<link href="<c:url value="/resources/css/registercss.css"/>" rel="stylesheet" type="text/css"> 
</head>
<body>
<br><br>
	<div class="container mt-5 p-2">
		<div class="row">
			<div class="col-md-6 offset-md-3 py-2 px-2">
				<h1 class="text-center mt-2">Create Account</h1>
				<form action="handle-student" method="post">

					<div class="form-group ">
						<label for="email">First Name</label> <input type="text"
							class="form-control " placeholder="firstname" name="firstName"
							id="firstname" required>
					</div>

					<div class="form-group">
						<label for="email">Last Name</label> <input type="text"
							class="form-control" placeholder="lastname" name="lastName"
							id="lastname"required>
					</div>

					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" placeholder="email" name="email"
							id="email"required>
					</div>
					
					<div class="form-group">
						<label for="sel1">Select Highest Qualification:</label> <select
							name="qualification" required class="form-control"
							id="qualification">
							<option value="">select qualification</option>
							<option>PHD</option>
							<option>Post Graduate</option>
							<option>Graduate</option>
							<option>Diploma</option>
						</select>
					</div>
					
					<div  class="container text-center">
					<a href="${pageContext.request.contextPath}" class="btn btn-danger">Back</a>
					<button type="submit" class="btn btn-warning">Create</button>
				</div>
			</form>
			</div>
		</div>

	</div>
</body>
</html>