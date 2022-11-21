<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
<% 
	String userId = null;
	if(session.getAttribute("MEMBERID")!= null){
		userId = (String)session.getAttribute("MEMBERID");
	}
		
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CMFC</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
					<a class="nav-link active"
						aria-current="page" href="CFMCMain.jsp">Home</a></li>
				</ul>
			<% 
			if (userId == null){
			%>
				<span class="navbar-text"> 
					<a href="join.jsp">회원가입 &nbsp;</a>
				</span>
				<span class="navbar-text"> 
					<a href="login.jsp">로그인</a>
				</span>
			<%
			} else {
			%>	
				<span class="navbar-text"> 
					<a href="mypage.jsp">마이페이지 &nbsp;</a>
				</span>
				<span class="navbar-text"> 
					<a href="logout.jsp">
					로그아웃</a>
				</span>
			<%
			} 
			%>
			</div>
		</div>
	</nav>

</body>
</html>