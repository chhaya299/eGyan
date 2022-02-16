<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
</head>

<body>
  <section class="courses">
		<div class="container py-3">
			<h3 class="text-center">About our Courses</h3>
	<!--first column-->
 			<div class="row py-3"> 
	
						<c:forEach items="${List}" var="clist"> 
					
						
						<div class="col-md-4">
						<div class="card" style="width: 18rem;">
							<div class="card-body">
								<h4 class="card-title">Course title :</h4>
								<h5 class="card-subtitle mb-2 text-muted">${clist.courseTitle}</h6>
								<p class="card-text">${clist.courseBrief}</p><br>
								<h6>Course Fee :${clist.courseFee}</h6>
								<h6>Number of chapter till now :${clist.numOfChapters} </h6>
								
								<a href="enrollStudent/${clist.courseID}" class="card-link text-center">Enroll</a> 
							</div>
						</div>
						</div>
						
				</c:forEach>
			</div>	
				</div>
				</section>
</body>
</html>