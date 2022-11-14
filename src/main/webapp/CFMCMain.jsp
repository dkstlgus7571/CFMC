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

	<%@ include file="navbar.jsp"%>

	<div class="container">
		<div id="form1">
			<p style="text-align: center;">강좌 조회</p>
			<div class="d-flex flex-column mb-3">
				<form>
					<div class="p-2">
						<label for="inputState">센터명 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">카테고리 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">시간 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">수강요일 <br /> <input
							class="form-check-input" type="checkbox" value="월" id="mon">
							<label class="form-check-label" for="mon"> 월</label> <input
							class="form-check-input" type="checkbox" value="화" id="tue">
							<label class="form-check-label" for="tue"> 화</label> <input
							class="form-check-input" type="checkbox" value="수" id="wed">
							<label class="form-check-label" for="wed"> 수</label> <input
							class="form-check-input" type="checkbox" value="목" id="thu">
							<label class="form-check-label" for="thu"> 목</label> <input
							class="form-check-input" type="checkbox" value="금" id="fri">
							<label class="form-check-label" for="fri"> 금</label>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">수강요일 <input type="text" value="">
						</label>
					</div>
					<button type="submit">조회하기</button>
				</form>
			</div>
		</div>

		<div id="form2">
			<p style="text-align: center;">시설 조회</p>
			<div class="d-flex flex-column mb-3">
				<form>
					<div class="p-2">
						<label for="inputState">센터명 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">시설명 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">세부시설 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">예약일자 <select>
								<option selected>전체보기</option>
								<option>...</option>
						</select> <select>
								<option selected>전체보기</option>
								<option>...</option>
						</select> <select>
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>

					<button type="submit">조회하기</button>
				</form>
			</div>
		</div>
	</div>

	<div id="form3"> 
		<table class="table table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">교육시간</th>
					<th scope="col">정원</th>
					<th scope="col">신청인원</th>
				</tr>
		<!-- 		<tr>
					<th scope="col">센터명</th>
					<th scope="col">시설명</th>
					<th scope="col">날짜</th>
					<th scope="col">예약현황</th>
				</tr> -->
			</thead>
			<tbody>
				<tr>
					<th scope="row">자유수영</th>
					<td>ㅇㅇㅇ</td>
					<td>13:00~15:00</td>
					<td>30</td>
					<td>12</td>
				</tr>
				<tr>
					<th scope="row">초급수영</th>
					<td>ㅁㅁㅁ</td>
					<td>15:00~17:00</td>
					<td>40</td>
					<td>29</td>
				</tr>
			<!-- <tr>
					<th scope="row">3</th>
					<td colspan="2">Larry the Bird</td>
					<td>@twitter</td>
					<td>@twitter</td>
				</tr> -->	
				
			</tbody>
		</table>
	</div>


</body>
</html>