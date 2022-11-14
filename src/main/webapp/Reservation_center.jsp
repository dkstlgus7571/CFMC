<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<style>
* {
	padding: 10px;
}
</style>
</head>
<body>
	<div class="dropdown">
		<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> 센터 </a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">Action</a></li>
			<li><a class="dropdown-item" href="#">Another action</a></li>
			<li><a class="dropdown-item" href="#">Something else here</a></li>
		</ul>
		<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> 시설명 </a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">Action</a></li>
			<li><a class="dropdown-item" href="#">Another action</a></li>
			<li><a class="dropdown-item" href="#">Something else here</a></li>
		</ul>
		<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> 세부시설 </a>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">Action</a></li>
			<li><a class="dropdown-item" href="#">Another action</a></li>
			<li><a class="dropdown-item" href="#">Something else here</a></li>
		</ul>
		<a class="btn btn-primary" href="#" role="button">조회</a>
		<table class="table">
			<tbody>
				<tr>
					<th scope="row">센터명</th>
					<td>복부스포츠센터</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">시설명</th>
					<td>다목적체육관</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">세부시설</th>
					<td>-</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">이용가능기간</th>
					<td>22-12-01 ~ 23-02-29</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">예약신청기간</th>
					<td>22-12-01 ~ 23-02-29</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">주소</th>
					<td>천안시 서북구 번영로 208(백석동, 종합운동장)</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th scope="row">전화번호</th>
					<td>041-123-1234</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<tbody>
				<tr>
					<td></td>
					<th scope="row">회차</th>
					<td></td>
					<th scope="row">이용시간</th>
					<th scope="row">예약현황</th>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox">1회차</td>
					<td></td>
					<td>10:00 ~ 12:00</td>
					<td>Y</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox">2회차</td>
					<td></td>
					<td>12:00 ~ 14:00</td>
					<td>Y</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox">3회차</td>
					<td></td>
					<td>14:00 ~ 16:00</td>
					<td>N</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<button type="button" class="btn btn-primary btn-lg" id="reserBtn">예약하기</button>
		<script src="<https:/ /cdn.jsdelivr.net/npm/bootstrap
			@5.2.2/dist/js/bootstrap.bundle.min.js>"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>
