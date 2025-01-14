<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인</title>
  <link rel="stylesheet" href="css/auth/login.css">
  <script src="js/auth/login.js" defer></script>
</head>
<body>
  <div>
    <div class="login-container">
      <p id="logo">TradeTalent</p>
      <h1>로그인</h1>
      <form class="auth-form">
        <input type="text" name="username" placeholder=" 사용자 이름 또는 이메일">
        <input type="password" name="password" placeholder="비밀번호">
        <button type="submit">로그인</button>
      </form>
      <p style="margin-top: 15px;">비밀번호를 잊으셨나요?</p>
    </div>
    <div class="signup-container">
      <p>계정이 없으신가요? <a href="/signup" onclick="goToSignup()">가입하기</a></p>
  </div>
  
</body>
</html>