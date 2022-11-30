<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function(){

		
					
		
	});
</script>
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center">
		<jsp:include page="/common/top.jsp"></jsp:include>
	</header>
	<!-- End Header -->
	<!-- ======= Sidebar ======= -->
	<jsp:include page="/common/side.jsp"></jsp:include>
	<!-- End Sidebar -->


	<main id="main" class="main">


		<div class="pagetitle">
			<h1>등급관리</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">카페관리</a></li>
					<li class="breadcrumb-item active">등급관리</li>
				</ol>
			</nav>
		</div>



		<div class="container">
			<div class="container-fluid">
				<div class="card">
				<div class="card-body">
				<form onclick="" style="cursor: pointer">
					
					<table class="table text-center" id="ranklist">
						<thead class="thead-light">
							<tr>
								<th></th>
								<th></th>
								<th>	
								</th>
								<th>
								<button type="button" class="btn float-right btn-success"
										id="saveRank" value="save" style="float: right">저장하기</button>	
								</th>
							</tr>

							<tr>
								<th>등급레벨</th>
								<th>등급 이름</th>
								<th>등급 포인트 기준</th>
								<th>수정/삭제</th>

							</tr>
						</thead>
						<tbody>
						${list}
							<c:forEach var="rank" items="${list}" varStatus="status">
							
								<c:if test="${rank.rank>0}">
									<tr class="${rank.rank}">

										<td class="${rank.rank}">${rank.rank}</td>
										<td><input type="text" class="form-control" id="name"
											placeholder="${rank.r_name}" value="${rank.r_name}" readonly></td>
											<input type="hidden" class="isReg" value="false">
										<td>
											<c:choose>
												<c:when test="${rank.rank == 1}">
														0 점 이상
												      </c:when>

												<c:otherwise>
													<input type="text" class="form-control" id="point"
														placeholder="${rank.r_point}" readonly>
														<input type="hidden" class="isReg" value="false">
												</c:otherwise>
											</c:choose>
										</td>
										<td>				
										<input type="button" class="editRank btn btn btn-secondary"
											value="수정하기" style="float: right">
										</td>

									</tr>
								</c:if>
							</c:forEach>
									
						</tbody>
					</table>
					<div style="display: inline-block; margin: 0 5px;  float: right;">
					<button type="button" class="btn btn btn-secondary"
										id="newRank" value="new">추가하기</button>
					<button type="button" class="btn btn btn-danger"
										id="delRank" value="new">삭제하기</button>
					</div>		
				</form>
				</div>
				</div>
			</div>

		</div>

	</main>



</body>

<!-- Vendor JS Files -->
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.min.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.min.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
</html>