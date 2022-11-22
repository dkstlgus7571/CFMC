<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.dto.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 신청 페이지</title>
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
	<% 
   int classCode = Integer.parseInt(request.getParameter("clsctName").toString());
	out.println(classCode);
 	OpenClass openClass = new OpenClass();
 	openClass.setOcCode(classCode);
 	
    OpenClassDao openClassDao = new OpenClassDao();
    ArrayList<OpenClass> selectAList = new ArrayList<OpenClass>();
    selectAList = openClassDao.openclassAllList(openClass);
    if(selectAList != null && selectAList.size() > 0){
    	for(int i=0; i<selectAList.size(); i++){
  %>

	<table class="table">
		<tbody>
			<tr>
				<th scope="row">강좌명</th>
				<td><%=selectAList.get(i).getC_name()%></td>
				<th scope="row">정원</th>
				<td><%=selectAList.get(i).getC_personnel()%></td>
				<th scope="row">신청인원</th>
				<td><%=selectAList.get(i).getOc_appliNum()%></td>
			</tr>
			<tr>
				<th scope="row">강사이름</th>
				<td><%=selectAList.get(i).getT_name()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">강좌소개</th>
				<td><%=selectAList.get(i).getC_intro()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">강습기간</th>
				<td><%=selectAList.get(i).getOc_classStart()%> ~ <%=selectAList.get(i).getOc_classEnd()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">수강요일</th>
				<td><%=selectAList.get(i).getOc_day()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">강좌시간</th>
				<td><%=selectAList.get(i).getEp_useStart()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">센터명</th>
				<td><%=selectAList.get(i).getCt_name()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">주요시설</th>
				<td><%=selectAList.get(i).getCt_facName()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">세부시설</th>
				<td><%=selectAList.get(i).getCt_facKind()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td><%=selectAList.get(i).getCt_address()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<th scope="row">준비물</th>
			<td><%=selectAList.get(i).getC_material()%></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
			<tr>
				<th scope="row">접수기간</th>
				<td><%=selectAList.get(i).getOc_acceptStart()%> ~ <%=selectAList.get(i).getOc_acceptEnd()%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<form name="Reservation_class_form" action="Reservation_class_save.jsp">
	<input type="hidden" name="classcode" value="<%=selectAList.get(i).getOcCode()%>">
	<button type="submit" class="btn btn-primary btn-lg" id="reserBtn">예약하기</button>
	</form>	
	<% } } %>
	<script>
 

</script>
</body>
</html>
