<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.CenterInfoDao"%>
<%@ page import="data.dto.CenterInfo"%>
<%@ page import="data.dao.OpenCenterDao"%>
<%@ page import="data.dto.OpenCenter"%>
<%@ page import="java.util.*"%>
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
	<%-- <%@ include file="navbar.jsp"%> --%>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<div class="p-2">
		<form>
			<label for="inputState">센터 <select id="ctName"
				onchange="selectCtName()">

					<option name="ctName" selected >

					</option>

			</select>
			</label> <label for="inputState">시설명 <select id='facName'>
					<option selected></option>
			</select>
			</label>
			 <label for="inputState">세부시설 <select id='facName'>
					<option selected></option>
			</select>
			</label>
		</form>
	</div>

	</div>
	<table class="table">
		<tbody>

			<tr>

				<th scope="row">센터명</th>
<%-- 		<% OpenCenterDao opencenterDao = new OpenCenterDao(); 
   			ArrayList<OpenCenter> openCenterList = opencenterDao.selectOpenCenter();%>									
   			<%
               if (openCenterList != null && openCenterList.size() > 0) {
                  for (OpenCenter opencenter : openCenterList) {
               %>
				<td><%=opencenter.getCt_name()%></td>
				<% }} %> --%>
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
				<th scope="row">이용가능일자</th>
				<td>22-12-01 ~ 23-02-29</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">예약마감일자</th>
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

	<script>
/*    function selectCtName(){
    //센터명이 있는 select를 찾음
      var name = document.getElementById("ctName"); 
    //선택된 센터명(옵션)의 인덱스 값을 찾고, 그 value를 저장
      var value = name.options[name.selectedIndex].value; 
      
       console.log(value);
      //facName id를 가진 객체를 찾음
      let facName1 = document.getElementById('facName'); 
      //facName1의 옵션 길이를 0으로 만듦(초기화)
      facName1.options.length = 0;
      //i=0~centerinfoallarr의 길이만큼 돌면서
      console.log(centerInfoAllArr);
      for (var i = 0; i < centerInfoAllArr.length; i++) {
         //선택되어 넘어온 value값 == 시설명칭이 같을 경우
         if(value == centerInfoAllArr[i].시설명칭){
            //option element를 생성하고
             let option = document.createElement('option');
             console.log(centerInfoAllArr[i].시설명칭);
             //option의 innerText를 설정함
             option.innerText = centerInfoAllArr[i].주요시설;
             console.log(option);
             console.log(option.innerText);
             //option.value = subOption[i]; 이것도 가능합니다.
             facName1.append(option);
         }
      }
   } */
   </script>
</body>
</html>
