<%@page import="java.time.LocalDateTime"%>
<%@page import="data.dao.OpenCenterDao"%>
<%@page import="data.dto.OpenCenter"%>
<%@page import="data.dao.ClassInfoDao"%>
<%@page import="data.dao.CenterInfoDao"%>
<%@page import="data.dto.ClassInfo"%>
<%@page import="data.dto.CenterInfo"%>
<%@ page import="java.util.*"%>
<%@ page import = "java.time.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="CFMCMain.css">
<meta charset="UTF-8">
<title>CFMC Main Page</title>
</head>
<body>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<jsp:include page="CFMCMain.jsp"/>


<% String selct = request.getParameter("clsctName");
	out.println(selct);
	/* String datetest = request.getParameter("avaPeriod").toString();
	out.println(datetest); */
	%>


	<!-- <div id="form3">
		<table class="table table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">교육시간</th>
					<th scope="col">정원</th>
					<th scope="col">신청인원</th>
				</tr>
						<tr>
					<th scope="col">센터명</th>
					<th scope="col">시설명</th>
					<th scope="col">세부시설명</th>
					<th scope="col">날짜</th>
					<th scope="col">시간</th>
					<th scope="col">예약현황</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">초급수영</th>
					<td>ㅁㅁㅁ</td>
					<td>15:00~17:00</td>
					<td>40</td>
					<td>29</td>
				</tr>

			</tbody>
		</table>
	</div>

 -->
</body>
</html>