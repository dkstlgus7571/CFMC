<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.OpenClassDao"%>
<%@ page import="data.dto.OpenClass"%>
<%@ page import="data.dao.CenterInfoDao"%>
<%@ page import="data.dto.CenterInfo"%>
<%@ page import="data.dao.OpenCenterDao"%>
<%@ page import="data.dto.OpenCenter"%>
<%@ page import="java.util.*"%>
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
<style>
* {
	padding: 10px;
}
</style>
</head>
<body>
	<%-- <%@ include file="navbar.jsp"%> --%>
	<!-- JavaScript Bundle with Popper -->
		<%@ include file="navbar.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script>
  	  let openClassGroupArr = [];
  	  let openClasssCNameArr = [];
   <%OpenClassDao openClassDao = new OpenClassDao();

	ArrayList<OpenClass> OpenClassCtNameList = openClassDao.selectCtNameOpenclassList();
	ArrayList<OpenClass> OpenClassGroupList = openClassDao.selectGruopOpenclassList();
	ArrayList<OpenClass> OpenClassCNameList = openClassDao.selectClassNameList();%>
	
	  <%
		for (OpenClass ocGroup : OpenClassGroupList) {%>	  	  	
		openClassGroupArr = [...openClassGroupArr, 
	  	 {"시설명칭":'<%=ocGroup.getCt_name()%>', "강좌분류":'<%=ocGroup.getC_group()%>'}];  	  			  
		<%}%>   	  	      
		
	  <%//센터정보 중 시설명칭과 주요시설만 배열에 저장함
		for (OpenClass ocCName : OpenClassCNameList) {%>	  	  	
		openClasssCNameArr = [...openClasssCNameArr, 
	  	 {"시설명칭":'<%=ocCName.getCt_name()%>', "강좌분류":'<%=ocCName.getC_group()%>', "강좌명":'<%=ocCName.getC_name()%>'}];  	  			  
		<%}%> 
   </script>
	<div class="p-2">
		<form name="ReservationClassForm" a>
		 <label for="inputState">센터<select class="form-select" id="ctName"
		 name="ctName" onchange="selectcGruop()">
            <option selected>센터명을 선택하세요.</option>
           <% if (OpenClassCtNameList != null && OpenClassCtNameList.size()> 0) {
                for (OpenClass ocName : OpenClassCtNameList) {
                	
                %>
                <option name="opCtName" > <%=ocName.getCt_name()%></option>              
                <% } }  %>
			</select>
			</label>
 			<label for="inputState">카테고리<select class="form-select"
			name="cGruop" id="cGruop" onchange="selectclassName()"> 
					<option selected>카테고리를 선택하세요.</option> 
			
			</select>
			</label>
			<label for="inputState">강좌명 <select class="form-select"
			name="className" id="className">
				<option selected>강좌명을 선택하세요.</option>
			</select>
			</label>
			<button type="submit" id='serchBtn'class="btn btn-outline-primary">조회</button>
		</form>
	</div>

	<table class="table">
		<tbody>

			<tr>
				<th scope="row">강좌명</th>
				<td>용진수영</td>
				<th scope="row">정원</th>
				<td>20명</td>
				<th scope="row">신청인원</th>
				<td>14명</td>
			</tr>
			<tr>
				<th scope="row">강사이름</th>
				<td>정용진</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">강좌소개</th>
				<td>개인혼영 100M, 장비사용(스노쿨)등 (자유형,배영,접영,평영,팔꺽기,오리발,스타트,턴 가능자만 신청 가능합니다.)<br/>
				강습진도에 맞게 수업을 신청해주시기 바라며, 진도와 맞지 않을 시 환불처리 됩니다.
				</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">강습기간</th>
				<td>22-12-01 ~ 23-02-29</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">수강요일</th>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td>토</td>
				<td>일</td>
			</tr>
			<tr>
				<th scope="row">강좌시간</th>
				<td>13:00</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">센터명</th>
				<td>천안종합운동장</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">주요시설</th>
				<td>수영장</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">준비물</th>
				<td>수영복, 수영모</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">접수기간</th>
			<td>22-12-01  ~ 23-02-29</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<button type="button" class="btn btn-primary btn-lg" id="reserBtn">예약하기</button>

<script>
 function selectcGruop(){
    var name = document.getElementById("ctName"); 
    var value = name.options[name.selectedIndex].value; 
    let cGruop = document.getElementById('cGruop');   
    	cGruop.options.length = 0;  
        let optionList = document.createElement('option');
        optionList.innerText = "카테고리를 선택하세요.";
        cGruop.append(optionList);        
      //세부시설명 초기화를 위한 코드-->
        var cGruopE = document.getElementById("cGruop");
        var value2 = cGruopE.options[cGruopE.selectedIndex].value;        
        if(value2.indexOf("카테고리를 선택하세요.") != -1){
           var cGruopE = document.getElementById('className');
           cGruopE.options.length = 0;          
          let option = document.createElement('option');
          option.innerText = "강좌명을 선택하세요.";         
          cGruopE.append(option);
        }
        //세부시설명 초기화를 위한 코드 끝.               
        for (var i = 0; i < openClassGroupArr.length; i++) {
           if(value == openClassGroupArr[i].시설명칭){
               let option = document.createElement('option');              
               option.innerText = openClassGroupArr[i].강좌분류;             
               cGruop.append(option);
           }
        }     
 } 
 //센터명 : ctName, 카테고리:cGruop, 강좌명:cN
 function selectclassName(){
	    var name = document.getElementById("ctName"); //카테고리 저장 값
	    var value = name.options[name.selectedIndex].value; 
	    var name2 = document.getElementById("cGruop"); //강좌명 저장 value
	    var value2 = name2.options[name2.selectedIndex].value; 

	  //세부시설 찾기
	    let className = document.getElementById('className');    
	    className.options.length = 0;  
	    let optionList = document.createElement('option');
	    optionList.innerText = "강좌명을 선택하세요.";
	    className.append(optionList);

	    for (var i = 0; i < openClasssCNameArr.length; i++) {
	       if(value == openClasssCNameArr[i].시설명칭 ){
	         if(value2 == openClasssCNameArr[i].강좌분류){
	          optionList = document.createElement('option');           
	          optionList.innerText = openClasssCNameArr[i].강좌명;          
	          className.append(optionList);
	         }
	          }else{
	         // console.log("시설명칭 확인 필요");
	       }
	    }           
	 }
 
/*   document.getElementById('serchBtn').addEventListener('click', (e)=> {
		e.preventDefault();
		let form = document.ReservationCenterForm;
	 	if(form.selecCenter.value == "센터명을 선택하세요."){
			alert("센터명을 선택해주세요.");
			return false;		
		}else if(form.selecName.value == "시설명을 선택하세요." || form.selecKind.value == "시설명을 선택하세요."){
			alert("시설명을 선택해주세요.");
			return false;		
		}
		else{
			form.action = 'Reservation_center_serch.jsp';
			form.submit();		
		}
	}) */

</script>
</body>
</html>
