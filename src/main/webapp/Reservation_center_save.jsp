<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>  
<%@ page import="data.dao.CenterInfoDao"%>
<%@ page import="data.dto.CenterInfo"%>
<%@ page import="data.dao.CenterRentDao"%>
<%@ page import="data.dao.OpenCenterDao"%>
<%@ page import="data.dto.OpenCenter"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	
	
	/* int memcode = Integer.parseInt(request.getParameter("memcode"));	 */
	int memcode = 199901011;	
	String epi = request.getParameter("epi");	
	String ctcode = request.getParameter("ctcode");	
	String avaperi = request.getParameter("avaperi");	
 	int YearStr = Integer.parseInt(avaperi.substring(0,4)); 
	int MonthStr = Integer.parseInt(avaperi.substring(0,7).substring(5)); 
	int DayStr = Integer.parseInt(avaperi.substring(8)); 
	LocalDate avaPeridate = LocalDate.of(YearStr, MonthStr, DayStr);
	
	String t = String.valueOf(memcode);

 	CenterRentDao centerRentDao = new CenterRentDao();
 	centerRentDao.procedure_centerrent_save(memcode,ctcode, Date.valueOf(avaPeridate),epi);
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