<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .form-group {
    width: 400px;
  }

  .text-center {
    text-align: center;
  }
</style>
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  function sample6_execDaumPostcode() {
    new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수
          var extraAddr = ''; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if(data.userSelectedType === 'R'){
              // 법정동명이 있을 경우 추가한다. (법정리는 제외)
              // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
              if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                  extraAddr += data.bname;
              }
              // 건물명이 있고, 공동주택일 경우 추가한다.
              if(data.buildingName !== '' && data.apartment === 'Y'){
                  extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
              }
              // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
              if(extraAddr !== ''){
                  extraAddr = ' (' + extraAddr + ')';
              }
              // 조합된 참고항목을 해당 필드에 넣는다.
              document.getElementById("sample6_extraAddress").value = extraAddr;
          
          } else {
              document.getElementById("sample6_extraAddress").value = '';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("sample6_detailAddress").focus();
      }
    }).open();
  }
</script>
<header>
  <jsp:include page="/jsp/include/topMenu.jsp" />
</header>
<section class="container">
  <h1 class="text-center">회원가입</h1>
  <form action="joinprocess.do" method="POST" class="text-center">
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" id="id" name="id" class="form-control" placeholder="아이디" >
    </div>
    <div class="form-group">
      <label for="password">패스워드</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="패스워드">
    </div>
    <div class="form-group">
      <label for="name">이름</label>
      <input type="text" id="name" name="name" class="form-control" placeholder="이름">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" id="email" name="email" class="form-control" placeholder="이메일">
    </div>
    <div class="form-group">
      <label for="jumin1">주민등록번호</label>
      <input type="text" id="jumin1" name="jumin1" class="form-control" placeholder="주민등록번호 앞 6자리" pattern="[0-9]{6}">
      <input type="text" id="jumin2" name="jumin2" class="form-control" placeholder="주민등록번호 뒷 첫자리" pattern="[0-9]{1}">
    </div>
    <div class="form-group">
      <label for="phone">전화번호</label>
      <input type="tel" id="phone" name="phone" class="form-control" placeholder="010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
    </div>
    <div class="form-group">
      <label for="sample6_postcode">우편번호</label>
      <div class="input-group">
        <input type="text" id="sample6_postcode" name="post" class="form-control" placeholder="우편번호">
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button" onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label for="sample6_address">주소</label>
      <input type="text" id="sample6_address" name="address" class="form-control" placeholder="주소">
    </div>
    <div class="form-group">
      <label for="sample6_detailAddress">상세주소</label>
      <input type="text" id="sample6_detailAddress" name="detailAddress" class="form-control" placeholder="상세주소">
    </div>
    <div class="form-group">
      <label for="sample6_extraAddress">참고항목</label>
      <input type="text" id="sample6_extraAddress" name="extraAddress" class="form-control" placeholder="참고항목">
    </div>
    <button type="submit" class="btn btn-primary">회원가입</button>
  </form>
</section>


<footer>
  <%@ include file="/jsp/include/bottom.jsp" %>
</footer>
</body>
</html>
