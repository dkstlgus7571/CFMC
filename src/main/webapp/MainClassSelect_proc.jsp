<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@page import="data.dao.*"%>
<%@page import="data.dto.*"%>

<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="CFMCMain.css">
<meta charset="UTF-8">
<title>조회완료 페이지</title>
</head>
<body>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<%
	String clctName = request.getParameter("clctName");
	String cGroup = request.getParameter("cGroup");
	String[] selDay = null;
	String textCN = "";
	
	if(request.getParameterValues("selDay") != null){
		selDay = request.getParameterValues("selDay");
	}
	if(request.getParameter("textCN") != null){
		textCN = request.getParameter("textCN");
	}
	
	//객체 생성 -> 넘어온 파라미터로 set
	//그 객체를 매개변수로 넘기는 메소드(select)를 작성해서 값을 받아와서 출력하면 되겠다! ! ! 
	OpenClass openClass = new OpenClass();
	
	OpenClassDao openClassDao = new OpenClassDao();
	
	ArrayList<OpenClass> openClassList = new ArrayList<OpenClass>();
	if(selDay != null){ //selday 있는 경우
		if(textCN.equals("")){ //textCN 없는 경우 - selday만 있음!
			openClassList = openClassDao.selectSearchBySelDay(clctName, cGroup, selDay);
		}else{ //둘 다 있는 경우
			openClassList = openClassDao.selectSearchByAll(clctName, cGroup, selDay, textCN);
		}
	}
	
	if(!textCN.equals("")){//textCN 있는 경우
		if(selDay == null){ //textCN만 있는 경우
			openClassList = openClassDao.selectSearchByText(clctName, cGroup, textCN);
		}else{//둘 다 있는 경우
			openClassList = openClassDao.selectSearchByAll(clctName, cGroup, selDay, textCN);
		}
	}
	
	if(selDay == null && textCN.equals("")){ //둘 다 없을 경우
		openClassList = openClassDao.selectAllList(clctName, cGroup);
	}
	%>
	
	<jsp:include page="CFMCMain.jsp" />

	<%
	
	/*if 를 걸어서 만약 arraylist가 null이 아니고+size가 0보다 클 경우 조회된 페이지로 이동  */
	/* 만약 예약가능한 데이터가 없는 경우 조회 페이지로 이동하게 해야 함!! */
	if(openClassList != null && openClassList.size()>0){ //조회된 결과 보여주기
		%>
	<div id="form3">
		<table class="table table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col"></th>
					<th scope="col">센터명</th>
					<th scope="col">강좌분류</th>
					<th scope="col">강좌명</th>
					<th scope="col">수강요일</th>
					<th scope="col">강의시간</th>
					<th scope="col">강좌기간</th>
					<th scope="col">접수기간</th>
					<th scope="col">신청인원/정원</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<%
					int checkboxV = 0;
				for(int i = 0; i<openClassList.size(); i++){ 
					checkboxV = openClassList.get(i).ocCode;

				%>
					<th scope="row">
					<input type="checkBox" name="classinfoAll" id="classinfoAll" value="<%=checkboxV%>" onClick='checkOnlyOne(this)'>
					</th>
					<td><%=openClassList.get(i).ct_name %></td>
					<td><%=openClassList.get(i).c_group %></td>
					<td><%=openClassList.get(i).c_name %></td>
					<td><%=openClassList.get(i).oc_day %></td>
					<td><%=openClassList.get(i).ep_useStart %> ~ <%=openClassList.get(i).ep_useEnd %></td>
					<td><%=openClassList.get(i).oc_classStart %> ~ <%=openClassList.get(i).oc_classEnd %></td>
					<td><%=openClassList.get(i).oc_acceptStart %> ~ <%=openClassList.get(i).oc_acceptEnd %></td>
					<td><%=openClassList.get(i).oc_appliNum %> / <%=openClassList.get(i).c_personnel %></td>
				</tr>
				<%	
						}
					%>
			</tbody>
		</table>
			<form name="chooseRegCls" id="chooseRegCls">
				<input type="hidden" name="clsctName"> 

				<button id="regClsBtn" type="submit">예약하기</button>
		</form>
	</div>
	<% }else{ //다시 조회페이지로 이동하기
		%>
	<script>
		alert("예약가능한 강좌가 없습니다!");
		location.href="CFMCMain.jsp";
		</script>
	<%	}%>


	<script>
	document.getElementById('regClsBtn').addEventListener('click', (e)=>{
	       e.preventDefault();
	       
	       const query = 'input[name="classinfoAll"]:checked'; //체크된 목록 쿼리문
	       const selectedEls = document.querySelector(query); // 쿼리문을 실행해 체크된 요소를 모두 가져옴
	       
	       /*1. 체크박스가 선택이 안 되었을 때 alert 창  뜨는 코드*/
	       if(document.querySelector(query) == null){
	    	   alert("예약시간을 선택해주세요!");
	    	   return false;
	       }else{
	       
	       let selectedCb = 0;
	       selectedCb = selectedEls.value;

	     	let form = document.chooseRegCls;
	     	
	     	form.clsctName.value = selectedCb.toString();

	     	console.log("예약폼으로 넘어갑니다!");
	     	form.action="Reservation_class.jsp";
	    	form.method="post";
	    	form.submit();
	       }
	});
	
	
		function checkOnlyOne(element) { //체크박스 중복 막아둠(라디오박스!)
		  
		  const checkboxes 
		      = document.getElementsByName("classinfoAll");
		  
		  checkboxes.forEach((cb) => {
		    cb.checked = false;
		  })
		  
		  element.checked = true;
		};
	
	</script>

</body>
</html>