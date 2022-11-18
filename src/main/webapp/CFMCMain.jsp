<%@page import="data.dao.ClassInfoDao"%>
<%@page import="data.dao.CenterInfoDao"%>
<%@page import="data.dto.ClassInfo"%>
<%@page import="data.dto.CenterInfo"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>CFMC Main Page</title>
</head>
<body>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<%@ include file="navbar.jsp"%>

	<script>
      let centernameArr = []; //센터명을 가져오는 배열
  	  let centerInfoAllArr = []; //centerinfo의 시설명칭, 주요시설, 세부시설을 모두 가져오는 배열
  	  let centerfacNameArr = []; //cenerinfo의 시설명칭, 주요시설만 골라 가져오는 배열
  	  
   <%CenterInfoDao centerInfoDao = new CenterInfoDao();

	ArrayList<CenterInfo> CenternameList = centerInfoDao.selectCenternameList();
	ArrayList<CenterInfo> CenterInfoAllList = centerInfoDao.selectCenterInfoList();
	ArrayList<CenterInfo> CenterfacNameList = centerInfoDao.selectCenterfcNameList();

		//센터명을 배열에 저장함
		for (CenterInfo ci : CenternameList) {%>
	
		centernameArr = [...centernameArr, '<%=ci.getCt_name()%>']; /*배열을 복사함!  */
	     
	      <%}%> 
	  
	  <%//센터정보 중 시설명칭과 주요시설만 배열에 저장함
		for (CenterInfo ci : CenterfacNameList) {%>
	  	  	
	  	centerfacNameArr = [...centerfacNameArr, 
	  	 {"시설명칭":'<%=ci.getCt_name()%>', "주요시설":'<%=ci.getCt_facName()%>'}];
	  	  		
	  	  	      <%}%> 
	  	  	      
	  	  	      
	  <%//센터정보의 이름 데이터를 모두 배열에 저장함
		for (CenterInfo ci : CenterInfoAllList) {%>
	  		  	
	  		  		centerInfoAllArr = [...centerInfoAllArr, 
	  		  			{"시설명칭":'<%=ci.getCt_name()%>', "주요시설":'<%=ci.getCt_facName()%>', "세부시설":'<%=ci.getCt_facKind()%>'}];
	  		  		
	  		  	      <%}%>  
	  		  	      
	  		  	      
	  		  	      
   </script>



	<div class="container">
		<div id="form1">
			<p style="text-align: center;">강좌 조회</p>
			<div class="d-flex flex-column mb-3">
				<form>
					<div class="p-2">
						<label for="inputState">센터명 <select class="form-select"
							id="centerNameSelect">
								<option value="전체보기">전체보기</option>
								<option value="북부스포츠센터">북부스포츠센터</option>
								<option value="종합운동장">종합운동장</option>
								<option value="기타">기타</option>
						</select>
						</label>
					</div>


					<div class="p-2">
						<label for="inputState">카테고리 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">시간 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">수강요일 <br /> <input
							class="form-check-input" type="checkbox" value="월" id="mon">
							<label class="form-check-label" for="mon"> 월</label> <input
							class="form-check-input" type="checkbox" value="화" id="tue">
							<label class="form-check-label" for="tue"> 화</label> <input
							class="form-check-input" type="checkbox" value="수" id="wed">
							<label class="form-check-label" for="wed"> 수</label> <input
							class="form-check-input" type="checkbox" value="목" id="thu">
							<label class="form-check-label" for="thu"> 목</label> <input
							class="form-check-input" type="checkbox" value="금" id="fri">
							<label class="form-check-label" for="fri"> 금</label>
						</label>

					</div>
					<div class="p-2">
						<label for="inputState">수강요일 <input type="text" value="">
						</label>
					</div>
					<button type="submit">조회하기</button>
				</form>
			</div>
		</div>

		<div id="form2">
			<p style="text-align: center;">시설 조회</p>
			<div class="d-flex flex-column mb-3">
				<form>
					<div class="p-2">
						<label for="inputState">센터명 <select class="form-select"
							id="ctName" onchange="selectCtName()">
								<option selected>센터명을 선택하세요</option>
								<%
								if (CenternameList != null && CenternameList.size() > 0) {
									for (CenterInfo ctInfo : CenternameList) {
								%>

								<option name="ctName" value=<%=ctInfo.getCt_name()%>>
									<%=ctInfo.getCt_name()%>
								</option>

								<%
								}
								}
								%>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">시설명 <select class="form-select"
							id="facName" onchange="selectfcKind()">
								<option selected>시설명을 선택하세요</option>
								<option name="facName"></option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">세부시설 <select class="form-select"
							id="fackind">
								<option selected>시설명을 선택하세요</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">예약일자 <select>
								<option selected>년도 선택</option>
								<option value></option>
								<option></option>
						</select> <select>
								<option selected>전체보기</option>
								<option>...</option>
						</select> <select>
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div>

					<button type="submit">조회하기</button>
				</form>
			</div>
		</div>
	</div>

	<div id="form3">
		<table class="table table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">교육시간</th>
					<th scope="col">정원</th>
					<th scope="col">신청인원</th>
				</tr>
				<!-- 		<tr>
					<th scope="col">센터명</th>
					<th scope="col">시설명</th>
					<th scope="col">날짜</th>
					<th scope="col">예약현황</th>
				</tr> -->
			</thead>
			<tbody>
				<tr>
					<th scope="row">자유수영</th>
					<td>ㅇㅇㅇ</td>
					<td>13:00~15:00</td>
					<td>30</td>
					<td>12</td>
				</tr>
				<tr>
					<th scope="row">초급수영</th>
					<td>ㅁㅁㅁ</td>
					<td>15:00~17:00</td>
					<td>40</td>
					<td>29</td>
				</tr>
				<!-- <tr>
					<th scope="row">3</th>
					<td colspan="2">Larry the Bird</td>
					<td>@twitter</td>
					<td>@twitter</td>
				</tr> -->

			</tbody>
		</table>
	</div>


	<script>
	//주요시설
   function selectCtName(){
      var name = document.getElementById("ctName"); 
      var value = name.options[name.selectedIndex].value; 
    	
      var name2 = document.getElementById("facName"); //세부시설 저장 value
      var value2 = name2.options[name2.selectedIndex].value; 
    //주요시설 찾기 -> facName2 id를 가진 객체를 찾음
          let facName1 = document.getElementById('facName'); 
    
          facName1.options.length = 0;
    
          let optionList = document.createElement('option');
          optionList.innerText = "시설명을 선택하세요";
          facName1.append(optionList);

          /* let fackind2 = document.getElementById('fackind');  
          
          fackind2.options.length = 0; */
         
          
          for (var i = 0; i < centerfacNameArr.length; i++) {
             if(value == centerfacNameArr[i].시설명칭){
                 let option = document.createElement('option');
                 
                 option.innerText = centerfacNameArr[i].주요시설;
                
                 facName1.append(option);
             }
          } 
   }
   
	
   //세부시설
   function selectfcKind(){
	   console.log("여기서부터 세부시설 시작");

      var name = document.getElementById("ctName"); //주요시설 저장 value
      var value = name.options[name.selectedIndex].value; 

      var name2 = document.getElementById("facName"); //세부시설 저장 value
      var value2 = name2.options[name2.selectedIndex].value; 

    //세부시설 찾기
      let fackind2 = document.getElementById('fackind'); 
      
      fackind2.options.length = 0;
    
      let optionList = document.createElement('option');
      optionList.innerText = "시설명을 선택하세요";
      fackind2.append(optionList);
    
   
      for (var i = 0; i < centerInfoAllArr.length; i++) {
         if(value == centerInfoAllArr[i].시설명칭 && value2 == centerInfoAllArr[i].주요시설){
        	
        	 optionList = document.createElement('option');
             
        	 optionList.innerText = centerInfoAllArr[i].세부시설;
             
             fackind2.append(optionList);
         	
        	 }else{
        	 console.log("시설명칭 확인해보세용");
         }
      }  
           
   }

   </script>



</body>
</html>