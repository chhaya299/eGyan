<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./Home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Chapter</h3>
							<form action="handle-chapter" method="post">

								<div class="row">

								<input type="hidden" name="chapterCourseId"
										class="form-control form-control-lg" id="courseid"
										value="${courseid}"/><br>
								<div class="col-md-6 mb-4">

										<div class="form-outline">
											<input type="text" id="lastName" name="chapterTitle"
												class="form-control form-control-lg" /> <br> <label
												class="form-label" for="lastName">ChapterTitle</label>
										</div>

								</div>
									<br>
									<div class="mt-4 pt-2">
										<input class="btn btn-warning btn-lg" type="submit" 
											value="Add" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	</script>
</body>
</html>