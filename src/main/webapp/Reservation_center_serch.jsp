<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.dto.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 예약 페이지</title>
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
      let centerNameArr = []; //센터명을 가져오는 배열
  	  let centerInfoAllArr = []; //centerinfo의 시설명칭, 주요시설, 세부시설을 모두 가져오는 배열
  	  let centerFacNameArr = []; //cenerinfo의 시설명칭, 주요시설만 골라 가져오는 배열
  	  
   <%CenterInfoDao centerInfoDao = new CenterInfoDao();
   
	ArrayList<CenterInfo> CenternameList = centerInfoDao.selectCenternameList();
	ArrayList<CenterInfo> CenterInfoAllList = centerInfoDao.selectCenterInfoList();
	ArrayList<CenterInfo> CenterfacNameList = centerInfoDao.selectCenterfcNameList();
	
		//센터명을 배열에 저장함
		for (CenterInfo ci : CenternameList) {%>	
		centerNameArr = [...centerNameArr, '<%=ci.getCt_name()%>'];
	    <%}%> 	
	  <%//센터정보 중 시설명칭과 주요시설만 배열에 저장함
		for (CenterInfo ci : CenterfacNameList) {%>	  	  	
		centerFacNameArr = [...centerFacNameArr, 
	  	 {"시설명칭":'<%=ci.getCt_name()%>', "주요시설":'<%=ci.getCt_facName()%>'}];  	  			  
		<%}%> 	  	  	      
	  <%//센터정보의 이름 데이터를 모두 배열에 저장함
		for (CenterInfo ci : CenterInfoAllList) {%>	  		  	
	  		  		centerInfoAllArr = [...centerInfoAllArr, 
	  		  			{"시설명칭":'<%=ci.getCt_name()%>', 
	  		  			"주요시설":'<%=ci.getCt_facName()%>', 
	  		  			"세부시설":'<%=ci.getCt_facKind()%>'}];	  		  		
	  		  	      <%}%>  		  	  
	  		  	      //console.log(centerFacNameArr);
	//오픈센터 모든 정보 가져오기
	
	</script>
	<div class="p-2">
		<form name="ReservationCenterForm" action="Reservation_center_serch.jsp">
		 <label for="inputState">센터명 <select class="form-select" id="ctName"
		 name="selecCenter"
            onchange="selectCtName()">
            <option selected>센터명을 선택하세요.</option>
            <% if (CenternameList !=null && CenternameList.size()> 0) {
                for (CenterInfo ctInfo : CenternameList) {
                %>   
                <option name="ctName" value=<%=ctInfo.getCt_name()%>>
              
                    <%=ctInfo.getCt_name()%>
                </option>
                <% } }  %>
			</select>
			</label>
			<label for="inputState">시설명 <select class="form-select"
			name="selecName"
				id="facName" onchange="selectfcKind()">
					<option selected>시설명을 선택하세요.</option>
					<!-- <option name="facName"></option> -->
			</select>
			</label>
			<label for="inputState">세부시설 <select class="form-select"
			name="selecKind"
				id="fackind">
					<option selected>시설명을 선택하세요.</option>
			</select>
			</label>
			<button type="submit" id='serchBtn'class="btn btn-outline-primary">조회</button>
		</form>
	</div>

			<table class="table">
		<tbody>
<% 
	String ctName = request.getParameter("selecCenter");
	String facName = request.getParameter("selecName");
	String facKind = request.getParameter("selecKind");				
					
%>
			<tr>
				<th scope="row">센터명</th>
				<td><%=ctName%></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">시설명</th>
				<td><%=facName%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">세부시설</th>
				<td><%=facKind%></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">이용가능일자</th>
				<td>22-12-01 ~ 23-02-29</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">예약마감일자</th>
				<td>22-12-01 ~ 23-02-29</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">주소</th>
				<td>천안시 서북구 번영로 208(백석동, 종합운동장)</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">전화번호</th>
				<td>041-123-1234</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">회차</th>
				<th scope="row">이용시간</th>
				<th scope="row">예약현황</th>
			</tr>
			<tr>
				<td>1회차</td>
				<td>10:00 ~ 12:00</td>
				<td>Y</td>
			</tr>
		</tbody>
	</table>
	<button type="button" class="btn btn-primary btn-lg" id="reserBtn">예약하기</button>

<script>
 function selectCtName(){
    var name = document.getElementById("ctName"); 
    var value = name.options[name.selectedIndex].value; 
    let facName1 = document.getElementById('facName');   
        facName1.options.length = 0;  
        let optionList = document.createElement('option');
        optionList.innerText = "시설명을 선택하세요.";
        facName1.append(optionList);        
        //세부시설명 초기화를 위한 코드-->
        var facNameE = document.getElementById("facName");
        var value2 = facNameE.options[facNameE.selectedIndex].value;        
        if(value2.indexOf("시설명을 선택하세요.") != -1){
           var fackNameE = document.getElementById('fackind');
           fackNameE.options.length = 0;          
          let option = document.createElement('option');
          option.innerText = "시설명을 선택하세요.";         
          fackNameE.append(option);
        }
        //세부시설명 초기화를 위한 코드 끝.        
        for (var i = 0; i < centerFacNameArr.length; i++) {
           if(value == centerFacNameArr[i].시설명칭){
               let option = document.createElement('option');              
               option.innerText = centerFacNameArr[i].주요시설;             
               facName1.append(option);
           }
        }     
 }
  
 //세부시설
 function selectfcKind(){
    var name = document.getElementById("ctName"); //주요시설 저장 value
    var value = name.options[name.selectedIndex].value; 
    var name2 = document.getElementById("facName"); //세부시설 저장 val ue
    var value2 = name2.options[name2.selectedIndex].value; 

  //세부시설 찾기
    let fackind2 = document.getElementById('fackind');    
    fackind2.options.length = 0;  
    let optionList = document.createElement('option');
    optionList.innerText = "시설명을 선택하세요.";
    fackind2.append(optionList);

    for (var i = 0; i < centerInfoAllArr.length; i++) {
       if(value == centerInfoAllArr[i].시설명칭 ){
         if(value2 == centerInfoAllArr[i].주요시설){
          optionList = document.createElement('option');           
          optionList.innerText = centerInfoAllArr[i].세부시설;          
           fackind2.append(optionList);
         }
          }else{
         // console.log("시설명칭 확인 필요");
       }
    }           
 }
 document.getElementById('serchBtn').addEventListener('click', (e)=> {
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
	})

</script>
</body>
</html>
