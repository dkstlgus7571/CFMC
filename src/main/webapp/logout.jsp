<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-type" content = "text/html"; charset="UTF-8">
<title>JSP 게시판</title>
</head>
<body>
<%
	session.invalidate(); 

%>
<script>
alert("로그아웃 되었습니다.");
location.href = "CFMCMain.jsp";
</script>
</body>
</html>