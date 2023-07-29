<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY은행</title>
<style>
  .form-signin {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
  }

  .form-signin form {
    width: 100%;
    max-width: 330px;
    padding: 15px;
    margin: auto;
  }
  
  .form-signin .form-floating {
    margin-bottom: 10px; 
  }
  
  .kakao-login {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 10px;
  }
  
  .kakao-login a {
    display: inline-block;
    padding: 10px 20px;
    background-color: #FFEB00;
    color: #8B4513;
    text-decoration: none;
    font-weight: bold;
    border-radius: 10px;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .kakao-login a:hover {
    background-color: #E6CB00;
  }
  
  .btn-primary {
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .btn-primary:hover {
    background-color: #0069d9;
  }
  
</style>
</head>
<body>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.2.0/kakao.min.js"
  integrity="sha384-x+WG2i7pOR+oWb6O5GV5f1KN2Ko6N7PTGPS7UlasYWNxZMKQA63Cj/B2lbUmUfuC" crossorigin="anonymous"></script>
<script>
  Kakao.init('b6c7bdcf80757ef7b907af195e15a355'); // 사용하려는 앱의 JavaScript 키 입력
</script>


<p id="token-result"></p>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8080/MYBANK/index.do',
    });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
</script>
  <header>
    <jsp:include page="/jsp/include/topMenu.jsp"/>
  </header>
  <section>
    <main class="form-signin">
      <form action="loginprocess.do" method="POST">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" name="id">
          <label for="floatingInput">ID</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword" name="password">
          <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
        
        <div class="kakao-login">
        <a id="kakao-login-btn" href="javascript:loginWithKakao()">
          <img alt="카카오로 로그인" src="/MYBANK/jsp/image/kakao_login.png">
          </a>
        </div>
      </form>
    </main>
  </section>
  <footer>
    <%@ include file="/jsp/include/bottom.jsp" %>
  </footer>
</body>
</html>




