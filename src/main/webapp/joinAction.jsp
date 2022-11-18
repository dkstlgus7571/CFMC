<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.dao.MemberInfoDao" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="data.dto.MemberInfo" scope="page" />
<jsp:setProperty name="user" property="mName" param = "userName"/>
<jsp:setProperty name="user" property="mBirth" param = "userBirth"/>	
<jsp:setProperty name="user" property="mPhoneNum" param = "userTel"/> 
<jsp:setProperty name="user" property="mEmail" param = "userID"/> 
<jsp:setProperty name="user" property="mPw" param = "userPassword"/> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%	// ---> 2.
		if (user.getmName() == null || user.getmBirth() == 0 || user.getmPhoneNum() == null
			|| user.getmEmail() == null || user.getmPw() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {  // ---> 3.
			MemberInfoDao memDAO = new MemberInfoDao();
			int result = memDAO.join(user);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else  {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'CFMCMain.jsp'");
				script.println("</script>");
			}	
		}
	%>
</body>
</html>