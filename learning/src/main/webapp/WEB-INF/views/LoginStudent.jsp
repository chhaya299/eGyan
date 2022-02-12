<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/logincss.css"/>" rel="stylesheet" type="text/css"> 
<title>Insert title here</title>
</head>
<body>
	<section class="Form my-4 mx-5">
		<div class="container ">
			<div class="row no-gutters">
				<div class="col-lg-5">
					<img src="./img1.jpg" class="img-fluid" alt="">
				</div>
				<div class="col-lg-7 px-5 pt-5">
				<%  if(request.getAttribute("msg")!=null)
				{ 
				%><h3><%=request.getAttribute("msg") %></h3>
			  <%}%>
					<h1>Sign in to your Account</h1>
					<form action="handle-loginStudent" method="post">
						<div class="form-row">
							<div class="col-lg-7">
								<input type="email" placeholder="Email-Addresss" name="email"
									class="form-control my-3 p-4">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="password" placeholder="*******" name="password"
									class="form-control my-3 p-4">
							</div>
						</div>
						<input type="hidden" value="student" name="type"/>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="submit" class="bt1 mt-3 mb-5">
							</div>
						</div>

					</form><%%>
				</div>
			</div>
		</div>
	</section>


</body>
</html>