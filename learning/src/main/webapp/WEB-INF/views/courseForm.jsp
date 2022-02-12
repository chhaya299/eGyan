<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="learning.Entity.Instructor" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page isELIgnored="false"  %>
   <%@include file="./base.jsp"%>
   <%@ include file="./Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/instrHome.css" rel="stylesheet"/> 
<meta charset="ISO-8859-1">
<title>instructor home</title>
</head>
<%

	if(request.getAttribute("msg")!=null){%>
		<div class="alert alert-danger" role="alert">
 			<%=request.getAttribute("msg")%>
 	<a href="showCourses"><button class=""btn btn-warning"">Back</button></a>	
</div>
		<%
	}else{
%>

<body>
<% Instructor i1 =(Instructor)session.getAttribute("USERNAME"); %>

 <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Course</h3>
            <form  action="handle-course" method="post">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" name="courseTitle" id="firstName" class="form-control form-control-lg" />
                    <label class="form-label" for="firstName">Course title</label>
                  </div>
				
                </div><br>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" id="lastName" name="courseBrief" class="form-control form-control-lg" />
                    <label class="form-label" for="lastName">Course Brief</label>
                  </div>

                </div><br>
             
		         <div class="col-md-6 mb-4 d-flex align-items-center">

                  <div class="form-outline datepicker w-100">
                    <input
                      type="text" name="courseFee"
                      class="form-control form-control-lg"
                      id="birthdayDate"/>
                    <label for="birthdayDate" class="form-label">Course Fee</label>
                  </div>
				</div>
			
               <input
                      type="hidden" name="instructorId"
                      class="form-control form-control-lg"
                      id="birthdayDate" value="<%=i1.getId()%>"
                    /><br>
              <div class="mt-4 pt-2">
                <input class="btn btn-warning btn-lg" type="submit" value="Submit" />
              </div>
			</div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body><%}%>
</html>