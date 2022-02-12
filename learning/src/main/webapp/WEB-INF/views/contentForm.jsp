<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./Home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Content Add</title>
</head>
<body>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Content</h3>
							<form action="handle-content" method="post"
								enctype="multipart/form-data">
								

								<select class="form-select" id="inputGroupSelect01" name="contentType">
									<option selected>Choose...</option>
									<option value="Text">Reading</option>
									<option value="Video">Video</option>
							</select>




								<div class="form-group">
									<label for="exampleFormControlInput1">Content Name</label> <input
										type="text" class="form-control" id="exampleFormControlInput1"
										name="contentTitle" placeholder="File-Name">
								</div>
								<input type="hidden" name="chapterContentId"
									value="${chapterId}" />


								<div class="form-group">
									<label for="exampleFormControlFile1">Choose File</label> <input
										type="file" class="form-control-file" name="data"
										id="exampleFormControlFile1">
								</div>

								<input type="submit" class="btn btn-warning">Add Content
								</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>