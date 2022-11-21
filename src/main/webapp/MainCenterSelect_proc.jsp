<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@page import="data.dao.ClassInfoDao"%>
<%@page import="data.dao.CenterInfoDao"%>
<%@page import="data.dto.ClassInfo"%>
<%@page import="data.dto.CenterInfo"%>
<%@page import="data.dto.OpenCenter"%>
<%@page import="data.dao.OpenCenterDao"%>
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
<title>조회완료 페이지</title>
</head>
<body>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<%
	String centerName = request.getParameter("centerName");
	String facilityName = request.getParameter("facilityName");
	String facilityKind = request.getParameter("facilityKind");
	int cenYear = Integer.parseInt(request.getParameter("cenYear"));
	int cenMonth = Integer.parseInt(request.getParameter("cenMonth"));
	int cenDay = Integer.parseInt(request.getParameter("cenDay"));
	
	LocalDate cenDate = LocalDate.of(cenYear, cenMonth, cenDay);
	
	//객체 생성 -> 넘어온 파라미터로 set
	//그 객체를 매개변수로 넘기는 메소드(select)를 작성해서 값을 받아와서 출력하면 되겠다! ! ! 
	OpenCenter openCenter = new OpenCenter(centerName, facilityName, facilityKind, cenDate);
	
	OpenCenterDao openCenterDao = new OpenCenterDao();
	
	ArrayList<OpenCenter> openCenterList = new ArrayList<OpenCenter>();
	openCenterList = openCenterDao.printSelectCenterInfo(openCenter);
	%>
	<jsp:include page="CFMCMain.jsp" />

	<%
	/*if 를 걸어서 만약 arraylist가 null이 아니고+size가 0보다 클 경우 조회된 페이지로 이동  */
	/* 만약 예약가능한 데이터가 없는 경우 조회 페이지로 이동하게 해야 함!! */

	if(openCenterList != null && openCenterList.size()>0){ //조회된 결과 보여주기
		%>
	<div id="form3">
		<table class="table table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">센터명</th>
					<th scope="col">시설명</th>
					<th scope="col">세부시설명</th>
					<th scope="col">날짜</th>
					<th scope="col">시간</th>
					<th scope="col">예약현황</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<%
					String dateNEpi = "";
				for(int i = 0; i<openCenterList.size(); i++){ 
					dateNEpi = openCenterList.get(i).oct_avaPeri+openCenterList.get(i).oct_epi;
				%>
					<th scope="row"><input type="checkBox" name="infoAll"
						id="infoAll" value="<%=dateNEpi%>" onClick='checkOnlyOne(this)'>
					</th>
					<th scope="row"><%=openCenter.getCt_name()%></th>
					<td><%=openCenterList.get(i).ct_facName %></td>
					<td><%=openCenterList.get(i).ct_facKind %></td>
					<td><%=openCenterList.get(i).oct_avaPeri %></td>
					<td><%=openCenterList.get(i).ep_useStart %> ~ <%=openCenterList.get(i).ep_useEnd %>
					</td>
					<td><%=openCenterList.get(i).ct_Ava %></td>
					<!--예약현황(근데 조회되는시간만 띄울 거면... 필요없지 않나?? 다 y로 나올텐데)-->
				</tr>
				<%	
						}
					%>
			</tbody>

		</table>
		<form name="chooseRevCt" id="chooseRevCt">
			<input type="hidden" name="ctName"
				value="<%=openCenter.getCt_name()%>"> 
				<input type="hidden"
				name="facName" value="<%=openCenter.getCt_facName()%>"> 
				<input type="hidden" name="facKind" value="<%=openCenter.getCt_facKind()%>">
			<input type="hidden" name="avaPeriod"> 
			<input type="hidden"
				name="epi">
			<button id="revCenterBtn" type="submit">예약하기</button>
		</form>
	</div>
	<% }else{ //다시 조회페이지로 이동하기
		%>
	<script>
		alert("예약가능한 시간이 없습니다!");
		location.href="CFMCMain.jsp";
		</script>
	<%	}%>


	<script>
	document.getElementById('revCenterBtn').addEventListener('click', (e)=>{
	       e.preventDefault();
	       
	       const query = 'input[name="infoAll"]:checked'; //체크된 목록 쿼리문
	       const selectedEls = document.querySelector(query); // 쿼리문을 실행해 체크된 요소를 모두 가져옴
	       
	       /*1. 체크박스가 선택이 안 되었을 때 alert 창  뜨는 코드*/
	       if(document.querySelector(query) == null){
	    	   alert("예약시간을 선택해주세요!");
	    	   return false;
	       }else{
	       
	       let selectedArr = "";
	       selectedArr = selectedEls.value;

	     	let form = document.chooseRevCt;
	     	
	     	form.avaPeri.value = selectedArr.substring(0,10).toString();
	     	form.epi.value = selectedArr.substring(10);

	     	console.log("예약폼으로 넘어갑니다!");
	     	form.action="Reservation_center.jsp";
	    	form.method="post";
	    	form.submit();
	       }
	});
	
	
		function checkOnlyOne(element) { //체크박스 중복 막아둠(라디오박스!)
		  
		  const checkboxes 
		      = document.getElementsByName("infoAll");
		  
		  checkboxes.forEach((cb) => {
		    cb.checked = false;
		  })
		  
		  element.checked = true;
		};
	
	</script>

</body>
</html>