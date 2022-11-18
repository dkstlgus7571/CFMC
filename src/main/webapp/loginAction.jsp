<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.dao.MemberInfoDao"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mem" class="data.dto.MemberInfo" scope="page">
	<jsp:setProperty name="mem" property="mEmail" param="userID"/>
	<jsp:setProperty name="mem" property="mPw" param="userPassword"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%	String userId = request.getParameter("userID");
		MemberInfoDao memDao = new MemberInfoDao();	
		
		int result = memDao.login(mem.getmEmail(), mem.getmPw());
		if (result == 1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			session.setAttribute("MEMBERID", userId);
			script.println("location.href = 'CFMCMain.jsp'");
			script.println("</script>");
			
		}
		else if (result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생헀습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>