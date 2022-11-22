<%@page import="data.dao.*"%>
<%@page import="data.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
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
<title>CFMC 메인 페이지</title>
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
  	  let centerfacNameArr = []; //cenerinfo의 시설명칭, 주요시설만 골라 가져오는 배열
  	  
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

//강좌조회
for (OpenClass ocGroup : OpenClassGroupList) {%>	  	  	
	openClassGroupArr = [...openClassGroupArr, 
  	 {"시설명칭":'<%=ocGroup.getCt_name()%>', "강좌분류":'<%=ocGroup.getC_group()%>'}];  	  			  
	<%}

//센터정보 중 시설명칭과 주요시설만 배열에 저장함
for (OpenClass ocCName : OpenClassCNameList) {%>	  	  	
	openClasssCNameArr = [...openClasssCNameArr, 
  	 {"시설명칭":'<%=ocCName.getCt_name()%>', "강좌분류":'<%=ocCName.getC_group()%>', "강좌명":'<%=ocCName.getC_name()%>'}];  	  			  
	<%}

//센터명을 배열에 저장함
for (CenterInfo ci : CenternameList) {%>
	
		centernameArr = [...centernameArr, '<%=ci.getCt_name()%>'];
	     
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
				<form name="ReservationClassForm">
					<div class="p-2">
						<label for="inputState">센터명
							<select class="form-select"
								id="clctName" name="clctName" onchange="selectcGroup()">
									<option selected>센터명을 선택하세요.</option>
									<%
									if (OpenClassCtNameList != null && OpenClassCtNameList.size() > 0) {
										for (OpenClass ocName : OpenClassCtNameList) {
									%>
									<option name="opCtName" value=<%=ocName.getCt_name()%>>
										<%=ocName.getCt_name()%></option>
									<%
									}
									}
									%>
							</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">카테고리<select class="form-select"
							name="cGroup" id="cGroup">
								<option selected>카테고리를 선택하세요.</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">수강요일 <br /> 
							<label class="form-check-label">
								<input class="form-check-input" type="checkbox" name="selDay" id="selMon" value="월" >
								월
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selTue" value="화" >
								화
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selWed" value="수" >
								수
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selThu" value="목" >
								목
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selFri" value="금" >
								금
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selSat" value="토" >
								토
							</label> 
							<label class="form-check-label" >
								<input class="form-check-input" type="checkbox" name="selDay" id="selSun" value="일" >
								일
							</label> 
					</div>
					<div class="p-2">
						<label for="inputState">강좌명 
						<input type="text" id="textCN"
							name="textCN" placeholder="강좌명을 검색하세요!">
						</label>
					</div>
					<button type="submit" id='serchBtn'>조회하기</button>
				</form>
			</div>
		</div>

		<div id="form2">
			<p style="text-align: center;">시설 조회</p>
			<div class="d-flex flex-column mb-3">
				<form name="CenterSelectForm">
					<div class="p-2">
						<label for="inputState">센터명 <select class="form-select"
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
						<label for="inputState">시설명 <select class="form-select"
							id="facilityName" name="facilityName" onchange="selectfcKind()">
								<option selected>시설명을 선택하세요</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">세부시설 <select class="form-select"
							id="facilityKind" name="facilityKind">
								<option selected>시설명을 선택하세요</option>
						</select>
						</label>
					</div>
					<div class="p-2">
						<label for="inputState">예약일자 <select id="cenYear"
							name="cenYear">
								<option value="년도" selected>년도</option>
								<option value="2022">2022년</option>
						</select> <select id="cenMonth" name="cenMonth">
								<option value="월" selected>월</option>
								<option value="11">11월</option>
						</select> <select id="cenDay" name="cenDay">
								<option value="일" selected>일</option>
								<%
								LocalDate now = LocalDate.now();

								OpenCenterDao openCenterDao = new OpenCenterDao();
								
								//이용가능일자와 예약마감일자를 출력하는 메소드
								ArrayList<OpenCenter> revAvaList = openCenterDao.selectOpenCenterRevAva();

								if (revAvaList != null && revAvaList.size() > 0) {
									for (OpenCenter oct : revAvaList) {
										//예약마감일자가 현재시간보다 뒤여야 하므로 작성한 조건문 - 예약마감일자가 지났을경우
										//이용가능일자 및 예약마감일자는 출력되지 않음
										if (oct.getOct_revPeri().isAfter(now)) {
								%>

								<option name="avaPeri" id="avaPeri"
									value=<%=oct.getOct_avaPeri().getDayOfMonth()%>>
									<%=oct.getOct_avaPeri().getDayOfMonth()%>일
								</option>

								<%
								}
								}
								}
								%>
						</select>
						</label> <br />
						<p>*예약은 최소 2일전까지 가능합니다
					</div>
					<button type="submit" id="centerSelBtn">조회하기</button>
				</form>
			</div>
		</div>
	</div>

	<script>
	 function selectcGroup(){ //센터명 선택 시, 해당 센터에 맞는 강좌 카테고리(강좌분류)가 나오게 하는 함수
		    var name = document.getElementById("clctName");  
		    var value = name.options[name.selectedIndex].value; 
		    
		    let cGruopE = document.getElementById("cGroup");   
		    	cGruopE.options.length = 0;  
		        let optionList = document.createElement('option');
		        optionList.innerText = "카테고리를 선택하세요.";
		        cGruopE.append(optionList); 
		        
		        for (var i = 0; i < openClassGroupArr.length; i++) {
		           if(value == openClassGroupArr[i].시설명칭){
		               let option = document.createElement('option');              
		               option.innerText = openClassGroupArr[i].강좌분류;             
		               cGruopE.append(option);
		           }
		        }     
		 };
		 
	 //강좌 조회 버튼 누를 때의 이벤트리스너
	 document.getElementById('serchBtn').addEventListener('click', (e)=> {
			e.preventDefault();
			let form = document.ReservationClassForm;
			
		 	if(form.clctName.value == "센터명을 선택하세요."){
				alert("센터명을 선택해주세요!");
				return false;		
			}else if(form.cGroup.value == "카테고리를 선택하세요."){
				alert("카테고리를 선택해주세요!");
				return false;		
			}else{
				 console.log("강좌조회 폼 넘어갑니다");
				form.action = 'MainClassSelect_proc.jsp';
				form.method="post";
				form.submit();	
			}
		});
	
	
	
	//주요시설 조회시, 센터명을 선택하면 해당 센터명에 맞는 시설명만 나오게 함+센터명 다시 선택시 세부시설까지 초기화됨
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
   
   //세부시설 조회시, 시설명을 선택하면 해당 시설명에 맞는 세부시설명만 나오게 함+시설명 다시 선택시 선택 초기화됨
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
        	 }
      }  
             
   }
   
   //시설조회 버튼 이벤트리스너
   document.getElementById('centerSelBtn').addEventListener('click', (e)=>{
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
    	   console.log("시설조회 폼 넘어갑니다");
    	   form.action="MainCenterSelect_proc.jsp";
    	   form.method="post"; //post 방식으로 수정하면 url에 파라미터값이 뜨지 않음!
    	   form.submit();
       }
       
    });
   
   
   </script>



</body>
</html>