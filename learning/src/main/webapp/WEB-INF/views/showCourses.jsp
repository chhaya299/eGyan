<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored = "false" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./Home.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="learning.Entity.Course"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/table.css"/>" rel="stylesheet" type="text/css"> 
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("courselist")==null){%>
	<div class="alert alert-danger" role="alert">
	     your are not publishes course 
			<a href="Home"><button class=""btn btn-warning"">Back</button></a>	
</div>
	<%}else{ %>

	<!-- show data -->
	<div class="container text-center"><br>
	<table >
		  <tr>
				<th scope="col">Course Title</th>
				<th scope="col">Course Brief</th>
				<th scope="col">No. of Chapter</th>
				<th scope="col">Action</th>
			</tr>
		<tbody>
			<c:forEach items="${courselist}" var="clist"> 
			<tr class="p-2">
				<td scope="col">${clist.courseTitle}</td>
				<td scope="col">${clist.courseBrief}</td>
			    <td scope="col">${clist.numOfChapters}</td>
			    <td scope="col"><a href="addChapters/${clist.courseID}">Add Chapter</a></td>
			</tr>
	</c:forEach>	
		
		</tbody>
	</table>
	</div><%} %>
</body>
</html>