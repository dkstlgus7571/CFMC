<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 예약 페이지</title>
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
	<%@ include file="navbar.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script>
      let centerNameArr = []; //센터명을 가져오는 배열
  	  let centerInfoAllArr = []; //centerinfo의 시설명칭, 주요시설, 세부시설을 모두 가져오는 배열
  	  let centerFacNameArr = []; //cenerinfo의 시설명칭, 주요시설만 골라 가져오는 배열
  	  
   <%CenterInfoDao centerInfoDao = new CenterInfoDao();

	ArrayList<CenterInfo> CenternameList = centerInfoDao.selectCenternameList();
	ArrayList<CenterInfo> CenterInfoAllList = centerInfoDao.selectCenterInfoList();
	ArrayList<CenterInfo> CenterfacNameList = centerInfoDao.selectCenterfcNameList();
	
	
		//센터명을 배열에 저장함
		for (CenterInfo ci : CenternameList) {%>	
		centerNameArr = [...centerNameArr, '<%=ci.getCt_name()%>'];
	    <%}%> 	
	  <%//센터정보 중 시설명칭과 주요시설만 배열에 저장함
		for (CenterInfo ci : CenterfacNameList) {%>	  	  	
		centerFacNameArr = [...centerFacNameArr, 
	  	 {"시설명칭":'<%=ci.getCt_name()%>', "주요시설":'<%=ci.getCt_facName()%>'}];  	  			  
		<%}%> 	  	  	      
	  <%//센터정보의 이름 데이터를 모두 배열에 저장함
		for (CenterInfo ci : CenterInfoAllList) {%>	  		  	
	  		  		centerInfoAllArr = [...centerInfoAllArr, 
	  		  			{"시설명칭":'<%=ci.getCt_name()%>', 
	  		  			"주요시설":'<%=ci.getCt_facName()%>', 
	  		  			"세부시설":'<%=ci.getCt_facKind()%>'}];	  		  		
	  		  	      <%}%>  		  	  
	  		  	      //console.log(centerFacNameArr);
   </script>
	<%
	String centerName = request.getParameter("ctName");
	String facilityName = request.getParameter("facName");
	String facilityKind = request.getParameter("facKind");
	String epi = request.getParameter("epi");
	String daytest = request.getParameter("avaPeriod");	
 	int YearStr = Integer.parseInt(daytest.substring(0,4)); 
	int MonthStr = Integer.parseInt(daytest.substring(0,7).substring(5)); 
	int DayStr = Integer.parseInt(daytest.substring(8)); 
	LocalDate avaPeridate = LocalDate.of(YearStr, MonthStr, DayStr);

	
	OpenCenter openCenter = new OpenCenter();
	openCenter.setCt_name(centerName);
	openCenter.setCt_facName(facilityName);
	openCenter.setCt_facKind(facilityKind);
	openCenter.setOct_epi(epi);
	openCenter.setOct_avaPeri(avaPeridate); 
	OpenCenterDao openCenterDao = new OpenCenterDao();
	
	ArrayList<OpenCenter> reservationDetailList = new ArrayList<OpenCenter>();
	
	reservationDetailList = openCenterDao.ReserCenter(openCenter);
	if(reservationDetailList != null && reservationDetailList.size()>0){ //조회된 결과 보여주기
		for(int i = 0; i<reservationDetailList.size(); i++){
		%>
	<table class="table">
		<tbody>
			<tr>
				<th scope="row">센터명</th>
				<td><%=openCenter.getCt_name()%></td>
			</tr>
			<tr>
				<th scope="row">시설명</th>
				<td><%=openCenter.getCt_facName()%></td>
			</tr>
			<tr>
				<th scope="row">세부시설</th>
				<td><%=openCenter.getCt_facKind()%></td>
			</tr>
			<tr>
				<th scope="row">이용가능일자</th>
				<td name="avqperi" value="<%=openCenter.getOct_avaPeri()%>"><%=openCenter.getOct_avaPeri()%></td>
			</tr>
			<tr>
				<th scope="row">예약마감일자</th>
				<td><%=reservationDetailList.get(i).getOct_revPeri()%></td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td><%=reservationDetailList.get(i).getCt_address()%></td>
			</tr>
			<tr>
				<th scope="row">전화번호</th>
				<td><%=reservationDetailList.get(i).getCt_tel()%></td>
			</tr>
			<tr>
				<th scope="row">회차</th>
				<td name="epi"
					value="<%=reservationDetailList.get(i).getOct_epi()%>"><%=reservationDetailList.get(i).getOct_epi()%></td>
			</tr>
			<tr>
				<th scope="row">이용시작시간</th>
				<td><%=reservationDetailList.get(i).getEp_useStart()%></td>
			</tr>
			<tr>
				<th scope="row">이용종료시간</th>
				<td><%=reservationDetailList.get(i).getEp_useEnd()%></td>
			</tr>
			<tr>
				<th scope="row">예약현황</th>
				<td><%=reservationDetailList.get(i).getCt_Ava()%></td>
			</tr>

		</tbody>
	</table>
	<form name="Reservation_save_Form" action="Reservation_center_save.jsp">
		<input type="hidden"
			value="<%=reservationDetailList.get(i).getCt_code()%>" name="ctcode">
		<input type="hidden"
			value="<%=reservationDetailList.get(i).getOct_epi()%>" name="epi">
		<input type="hidden" value="<%=openCenter.getOct_avaPeri()%>"
			name="avaperi">
		<button type="submit" class="btn btn-primary btn-lg" id="reserBtn">예약하기</button>
	</form>
	<%}} %>
	<script>

</script>
</body>
</html>
