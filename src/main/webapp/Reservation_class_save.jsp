<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>  
<%@ page import="data.dao.ClassRegDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	

	int mcode = Integer.parseInt(session.getAttribute("MEMCODE").toString());	
	int ccode = Integer.parseInt(request.getParameter("classcode"));	
	
 	ClassRegDao classregDao = new ClassRegDao();
 	classregDao.procedure_openclass_save(mcode, ccode); 
 	%>
 
 	<script>
 	if(confirm("예약이 완료되었습니다.마이페이지로 이동하겠습니까?") == true){
 		location.href = "mypage.jsp";
 	}else {		
 		location.href = "CFMCMain.jsp";
 	}

	</script>
		 
</body>
</html>