<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
<section class="d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="container">
        <h1 class="text-center">문의사항 작성</h1>
        <form action="postingprocess.do" method="POST">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">글제목</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="글제목">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">글 내용</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="3" placeholder="글 내용을 입력하세요"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>
</section>



	<footer>
		<%@ include file="/jsp/include/bottom.jsp"%>
	</footer>
</body>
</html>