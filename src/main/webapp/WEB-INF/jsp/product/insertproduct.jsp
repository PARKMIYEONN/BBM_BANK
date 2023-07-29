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
  <form action="insertproductprocess.do" method="POST" class="text-center">
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
      <label for="enddate">가입기한</label>
      <input type="date" id="enddate" name="edate" class="form-control">
    </div>
    <div class="form-group">
      <label for="rate">적용이율</label>
      <input type="text" id="prate" name="prate" class="form-control">
    </div>
 
    <button type="submit" class="btn btn-primary">등록</button>
  </form>
</section>


<footer>
  <%@ include file="/jsp/include/bottom.jsp" %>
</footer>

</body>
</html>