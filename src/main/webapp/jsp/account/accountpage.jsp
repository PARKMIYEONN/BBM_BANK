<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BBM은행</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	<section>
<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="/MYBANK/newaccount.do">계좌 생성</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/MYBANK/myaccount.do">계좌 조회</a>
  </li>
  <li class="nav-item">
     <a class="nav-link" href="/MYBANK/openbanking.do">오픈뱅킹</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Disabled</a>
  </li>
</ul>

	</section>
	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>