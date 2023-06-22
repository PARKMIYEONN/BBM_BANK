<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBM은행</title>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
<section class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title">${post.postNo}.${post.title}</h3>
                    <hr> <!-- 날짜와 콘텐츠 구분선 -->
                    <div class="card-text">
                        <p class="post-info">${post.writer} | ${post.regDate}</p>
                        <div class="content-area">
                            <p>${post.content}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<style>
    .post-info {
        font-size: 14px;
        color: #888;
    }
    .content-area {
        margin-top: 10px;
    }
</style>


	
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>