<%@page import="java.time.LocalDateTime"%>
<%@page import="data.dao.*"%>
<%@page import="data.dto.*"%>
<%@page import="data.dao.OpenCenterDao"%>
<%@page import="data.dao.OpenClassDao"%>
<%@page import="data.dto.OpenCenter"%>
<%@page import="data.dao.ClassInfoDao"%>
<%@page import="data.dao.CenterInfoDao"%>
<%@page import="data.dto.ClassInfo"%>
<%@page import="data.dto.CenterInfo"%>
<%@ page import="java.util.*"%>
<%@ page import = "java.time.*" %>

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
	  //강좌조회
	   let openClassGroupArr = [];
       let openClasssCNameArr = [];
		
	  //시설조회
      let centernameArr = []; //센터명을 가져오는 배열
  	  let centerInfoAllArr = []; //centerinfo의 시설명칭, 주요시설, 세부시설을 모두 가져오는 배열
  	  let centerFacNameArr = []; //cenerinfo의 시설명칭, 주요시설만 골라 가져오는 배열
  	  
   <%CenterInfoDao centerInfoDao = new CenterInfoDao();
     OpenClassDao openClassDao = new OpenClassDao();

	//강좌조회
	ArrayList<OpenClass> OpenClassCtNameList = openClassDao.selectCtNameOpenclassList();
   	ArrayList<OpenClass> OpenClassGroupList = openClassDao.selectGruopOpenclassList();
  	ArrayList<OpenClass> OpenClassCNameList = openClassDao.selectClassNameList();
  	  
  	  
	//시설조회  	  
	ArrayList<CenterInfo> CenternameList = centerInfoDao.selectCenternameList();
	ArrayList<CenterInfo> CenterInfoAllList = centerInfoDao.selectCenterInfoList();
	ArrayList<CenterInfo> CenterfacNameList = centerInfoDao.selectCenterfcNameList();

//센터명을 배열에 저장함
for (CenterInfo ci : CenternameList) {%>
	
		centerNameArr = [...centerNameArr, '<%=ci.getCt_name()%>']; /*배열을 복사함!  */
	     
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
					<!-- <div class="p-2">
						<label for="inputState">시간 <select class="form-select">
								<option selected>전체보기</option>
								<option>...</option>
						</select>
						</label>
					</div> -->
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
						<label for="inputState">강좌명 <input type="text" value="">
						</label>
					</div>
					<button type="submit">조회하기</button>
				</form>
			</div>
		</div>

		<div id="form2">
			<p style="text-align: center;">시설 조회</p>
			<div class="d-flex flex-column mb-3">
				<form name="CenterSelectForm">
					<div class="p-2">
						<label for="inputState">센터명 
						<select class="form-select"
							id="centerName" name="centerName" onchange="selectCtName()">
								<option selected>센터명을 선택하세요</option>
								<%
								if (CenternameList != null && CenternameList.size() > 0) {
									for (CenterInfo ctInfo : CenternameList) {
								%>

								<option name="ctName" id="ctName" value=<%=ctInfo.getCt_name()%>>
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
						<label for="inputState">시설명 
							<select class="form-select"
							id="facilityName" name="facilityName" onchange="selectfcKind()">
								<option selected>시설명을 선택하세요</option>
							</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">세부시설 
						<select class="form-select"
							id="facilityKind" name="facilityKind">
								<option selected>시설명을 선택하세요</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">예약일자 
							<select id = "cenYear" name="cenYear">
								<option value="년도" selected>년도</option>
								<option value="2022">2022년</option>
							</select> 
							<select id = "cenMonth" name="cenMonth">
								<option value="월" selected>월</option>
								<option value="11">11월</option>
							</select> 
							<select id = "cenDay" name="cenDay">
								<option value="일" selected>일</option>
								<%
								LocalDate now = LocalDate.now();
																
								OpenCenterDao openCenterDao = new OpenCenterDao();
								ArrayList<OpenCenter> revAvaList = openCenterDao.selectOpenCenterRevAva();
								
								if (revAvaList != null && revAvaList.size() > 0) {
									for (OpenCenter oct : revAvaList) {
										//예약마감일자가 현재시간보다 뒤여야 하므로 작성한 조건문
										if(oct.getOct_revPeri().isAfter(now)){ 
								%>

								<option name="avaPeri" id="avaPeri" value=<%=oct.getOct_avaPeri().getDayOfMonth()%>>
									<%=oct.getOct_avaPeri().getDayOfMonth()%>일
								</option>

								<%
										}
								}
								}
								%>
							</select>
						</label>
						<br/>
							<p>*예약은 최소 2일전까지 가능합니다
					</div>
					<button type="submit" id = "centerSelBtn">조회하기</button>
				</form>
			</div>
		</div>
	</div>

	
	<script>
	//주요시설 조회
   function selectCtName(){
      var name = document.getElementById("centerName"); 
      var value = name.options[name.selectedIndex].value; 

      let facName1 = document.getElementById('facilityName'); 
    
          facName1.options.length = 0;
    
          let optionList = document.createElement('option');
          optionList.innerText = "시설명을 선택하세요";
          facName1.append(optionList);
          
          //세부시설명 초기화를 위한 코드-->
          var facNameE = document.getElementById("facilityName");
          var value2 = facNameE.options[facNameE.selectedIndex].value; 
          
          if(value2.indexOf("시설명을 선택하세요") != -1){
        	  var fackNameE = document.getElementById('facilityKind');
        	  fackNameE.options.length = 0;
        	  
        	 let option = document.createElement('option');
        	 option.innerText = "시설명을 선택하세요";
        	 
        	 fackNameE.append(option);
          }
          //세부시설명 초기화를 위한 코드 끝.
          
          for (var i = 0; i < centerfacNameArr.length; i++) {
             if(value == centerfacNameArr[i].시설명칭){
                 let option = document.createElement('option');
                 
                 option.innerText = centerfacNameArr[i].주요시설;
                
                 facName1.append(option);
             }
          } 
        
   }
   
	
   //세부시설 조회
   function selectfcKind(){
      var name = document.getElementById("centerName"); //주요시설 저장 value
      var value = name.options[name.selectedIndex].value; 

      var name2 = document.getElementById("facilityName"); //세부시설 저장 value
      var value2 = name2.options[name2.selectedIndex].value; 

    //세부시설 찾기
      let fackind2 = document.getElementById('facilityKind'); 
      
      fackind2.options.length = 0;
    
      let optionList = document.createElement('option');
      optionList.innerText = "시설명을 선택하세요";
      fackind2.append(optionList);
      
      for (var i = 0; i < centerInfoAllArr.length; i++) {
         if(value == centerInfoAllArr[i].시설명칭 ){
        	if(value2 == centerInfoAllArr[i].주요시설){
        	 optionList = document.createElement('option');
             
        	 optionList.innerText = centerInfoAllArr[i].세부시설;
             
             fackind2.append(optionList);
        	}
        	 }else{
        	 console.log("시설명칭 확인 필요");
         }
      }  
             
   }
   
   //시설조회 폼 버튼 이벤트리스너
   document.getElementById('centerSelBtn').addEventListener('click', (e)=>{
       //click했을 때 수행할 내용 작성
       e.preventDefault();
       
       let form = document.CenterSelectForm;
       if(form.centerName.value == "센터명을 선택하세요") {   
    	   alert('센터명을 다시 선택하세요');
           return false;
       }else if(form.facilityName.value == "시설명을 선택하세요" || form.facilityKind.value == "시설명을 선택하세요"){
    	   alert('시설명을 다시 선택하세요');
           return false;
       }else if(form.cenYear.value == "년도" || form.cenMonth.value == "월" || form.cenDay.value == "일"){
    	   alert('예약일자를 다시 선택하세요.');
    	   return false;
       }else{
    	   console.log("폼 넘어갑니다");
    	   form.action="MainCenterSelect_proc.jsp";
    	   form.method="post"; //post 방식으로 수정하면 url에 파라미터값이 뜨지 않음!
    	   form.submit();
       }
       
    });
   
   
   </script>



</body>
</html>