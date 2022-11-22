<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="data.dao.CenterRentDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 예약 완료</title>
</head>
<body>

	<%	
	
	if(session.getAttribute("MEMCODE") != null){
		int memcode = Integer.parseInt(session.getAttribute("MEMCODE").toString());	
		String epi = request.getParameter("epi");	
		String ctcode = request.getParameter("ctcode");	
		String avaperi = request.getParameter("avaperi");	
	 	int YearStr = Integer.parseInt(avaperi.substring(0,4)); 
		int MonthStr = Integer.parseInt(avaperi.substring(0,7).substring(5)); 
		int DayStr = Integer.parseInt(avaperi.substring(8)); 
		LocalDate avaPeridate = LocalDate.of(YearStr, MonthStr, DayStr);
	
	
	 	CenterRentDao centerRentDao = new CenterRentDao();
	 	centerRentDao.procedure_centerrent_save(memcode,ctcode, Date.valueOf(avaPeridate),epi);
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 후 이용해주세요!')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
	}
	
 	%>

	<script>
 	if(confirm("예약이 완료되었습니다.마이페이지로 이동하겠습니까?") == true){
 		location.replace('mypage.jsp');
 	}else {		
 		location.href = "CFMCMain.jsp";
 	}

	</script>

</body>
</html>