<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./Home.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="learning.Entity.Content"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/table.css"/>" rel="stylesheet"
	type="text/css">
</style>
<meta charset="ISO-8859-1">
<title>show contents</title>
</head>
<body>
	<!-- show data -->
	<%
	if (request.getAttribute("msg") != null) {
	%><h3><%=request.getAttribute("msg")%></h3>
	<%
	} else {
	%>


	<div class="container text-center">
		<br>
		<table>
			<tr>
				<th scope="col">Content Id</th>
				<th scope="col">Content Title</th>
				<th scope="col">Content Chapter Id</th>
				<th scope="col">Content Type</th>
				<th scope="col">Data File</th>
				

			</tr>
			<tbody>
				<c:forEach items="${content}" var="clist">
					<tr class="p-2">
						<td scope="col">${clist.contentId}</td>
						<td scope="col">${clist.contentTitle}</td>
						<td scope="col">${clist.chapterContentId}</td>
						<td scope="col">${clist.contentType}</td>
						<td scope="col" >
						<c:if test="${clist.contentType eq 'video/mp4'}">
							<video src="${clist.fileName}" controls border=1 height=100 width=100></video>
						</c:if>
						<c:if test="${clist.contentType eq 'image/png'}">
							<img alt="image" src="${clist.fileName}" controls border=1 height=100 width=100></img>
						</c:if>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<%
	}
	%>
</body>
</html>