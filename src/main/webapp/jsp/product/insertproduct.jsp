<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
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
  
  .form-check-label {
  	margin-left: 10px;
  	margin-right: 20px;
  }
</style>
</head>
<body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<header>
  <jsp:include page="/jsp/include/topMenu.jsp" />
</header>
<section class="container">
  <h1 class="text-center">상품등록</h1>
  <form action="insertproduct.do" method="POST" class="text-center">
    <div class="form-group">
      <label for="productname">상품명</label>
      <input type="text" id="productname" name="pname" class="form-control">
    </div>
    
   <div class="form-group">
  <label for="producttype">상품종류</label>
  <div class="form-check">
    <input type="radio" id="type1" name="ptype" value="예금" class="form-check-input">
    <label for="type1" class="form-check-label">예금</label>
    <input type="radio" id="type2" name="ptype" value="적금" class="form-check-input">
    <label for="type2" class="form-check-label">적금</label>
  </div>
</div>
    <div class="form-group">
      <label for="email"></label>
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