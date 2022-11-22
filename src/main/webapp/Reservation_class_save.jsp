<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="data.dao.ClassRegDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	
	if(session.getAttribute("MEMCODE") != null){
		int mcode = Integer.parseInt(session.getAttribute("MEMCODE").toString());	
		int ccode = Integer.parseInt(request.getParameter("classcode"));	
		
	 	ClassRegDao classregDao = new ClassRegDao();
	 	classregDao.procedure_openclass_save(mcode, ccode); 
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
	 		location.href = "mypage.jsp";
	 	}else {		
	 		location.href = "CFMCMain.jsp";
	 	}
	</script>

</body>
</html>