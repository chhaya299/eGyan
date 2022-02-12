<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./Home.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="learning.Entity.Chapter" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/table.css"/>" rel="stylesheet" type="text/css"> 
<meta charset="ISO-8859-1">
<title>Show Chapters</title>
</head>
<body>
<body>
	<!-- show data -->
	<div class="container text-center"><br>
	<table >
		  <tr>
		  		
		  		<th scope="col">CourseId</th>
				<th scope="col">Chapters Title</th>
				<th scope="col">Number of Reading Content</th>
				<th scope="col">Number of Video</th>
				<th scope="col">Action</th>
			</tr>
		<tbody>
			<c:forEach items="${chapterlist}" var="clist">  
			<tr class="p-2"> 
			
				<td scope="col">${clist.chapterCourseId}
		        <td scope="col">${clist.chapterTitle}</td> 
			    <td scope="col">${clist.numOfReading}</td> 
			    <td scope="col">${clist.numOfVideo}</td>
		        <td scope="col"><a href="addContents/${clist.chapterId}">Add Content</a></td>
			</tr> 
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>

</body>
</html>