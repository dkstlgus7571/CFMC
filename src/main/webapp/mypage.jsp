<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.dao.MemberInfoDao" %>
<%@ page import = "data.dto.MemberInfo"%>
<%@ page import = "data.dto.ClassReg"%>
<%@ page import = "data.dto.CenterRent"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import ="java.util.ArrayList" %>
<jsp:useBean id="cr" class="data.dto.ClassReg" scope="page"/>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="data.dto.MemberInfo" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>

</head>
<body>
	<nav>
		<%@ include file="navbar.jsp"%>
	</nav>
	<%	// ---> 2.
		MemberInfoDao dao = new MemberInfoDao();
// 		ArrayList userInfo =new ArrayList();
		user.setmEmail((String)session.getAttribute("MEMBERID"));
		user.setmPw((String)session.getAttribute("MEMBERPW"));
		MemberInfo userInfo = new MemberInfo();
		userInfo = dao.myInfo(user);	
	%>
	
		<span class="d-block p-2 text-bg-primary">개인정보조회</span>
		<ul class="list-group list-group-flush">
		
		<li class="list-group-item"><h6>이름 </h6><%=userInfo.getmName() %></li>
 		<li class="list-group-item"><h6>생년월일 </h6><%=userInfo.getmBirth() %></li>
  		<li class="list-group-item"><h6>번호 </h6><%=userInfo.getmPhoneNum() %></li>
  		<li class="list-group-item"><h6>가입날짜 <h6><%=userInfo.getmDate() %></li>
		</ul>

       <% %>
    <span class="d-block p-2 text-bg-primary">강좌예약내역</span>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">강좌이름</th>
				<th scope="col">시설이름</th>
				<th scope="col">강사이름</th>
				<th scope="col">신청날짜</th>

			</tr>
		</thead>
		<tbody>
			<%	
  	ArrayList reglist = dao.regInfo(userInfo);
  	ClassReg cr1 = new ClassReg();
  	for(int i=0; i<reglist.size(); i++) {
  		
  		cr1 = (ClassReg)reglist.get(i);

  		
  	%>
			<tr>
				<th scope="row"><%= i+1 %></th>
				<td><%=cr1.getCr_cName() %></td>
				<td><%=cr1.getCr_ctName() %></td>
				<td><%=cr1.getCr_tName() %></td>
				<td><%=cr1.getCr_appliDate() %></td>
			</tr>
			<%} %>



		</tbody>
	</table>
	<span class="d-block p-2 text-bg-primary">시설대여내역</span>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">시설명칭</th>
				<th scope="col">주요시설</th>
				<th scope="col">세부시설</th>
				<th scope="col">대관날짜</th>
				<th scope="col">이용시작시간</th>
				<th scope="col">이용종료시간</th>
				<th scope="col">신청날짜</th>

			</tr>
		</thead>
		<tbody>
			<%	
  	ArrayList rentlist = dao.rentInfo(userInfo);
  	CenterRent crt = new CenterRent();
  	for(int i=0; i<rentlist.size(); i++) {
  		
  		crt = (CenterRent)rentlist.get(i);

  		
  	%>
			<tr>
				<th scope="row"><%= i+1 %></th>
				<td><%=crt.getCtr_ctName() %></td>
				<td><%=crt.getCtr_ctFacName() %></td>
				<td><%=crt.getCtr_ctFacKind() %></td>
				<td><%=crt.getCtr_appliDate() %></td>
				<td><%=crt.getCtr_epiUseStart() %></td>
				<td><%=crt.getCtr_epiUseEnd() %></td>
				<td><%=crt.getCtr_revDate() %></td>
			</tr>
			<%} %>



		</tbody>
	</table>

</body>
</html>