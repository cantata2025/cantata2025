<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/css/index.css">
  <script
      src="/js/index.js"
      type="module"
      defer
    ></script>
</head>
<body>
  <header>
    <div class="head-container">
      <div class="head-wrap">
        <div class="logo">
          <span><a href="/">TradeTalent</a></span>
        </div>
        <ul class="nav">
          <li><a href="#">프로필</a></li>
          <li><a href="/message">메세지</a></li>
          <li><a href="/newlesson">레슨등록</a></li>
          <li><a href="#">알아보기</a></li>
        </ul>
        <div class="search-wrap">
          <button id="search-btn" type="button">
            <span>검색할 내용을 입력하세요</span>
            <i class="fas fa-search"></i>
          </button>
        </div>
        <a class="logout" href="#">Logout</a>
      </div>
    </div>
  </header>
  <main>
    <div id="main-wrap">
      <div class="main-top">
        <div id="main-image">
          <div id="image-text">
            <p class="logo">TradeTalent</p>
            <p>재능을 나누고</p>
            <p>함께 성장하세요!</p>
          </div>
        </div>
      </div>
      
      <div class="lessons" id="lessons-info">
        <p>최근 등록된 레슨</p>
      </div>
      
      <ul id="lessons"></ul>
    </div>
  </main>
  <footer>
    <div class="foot-container">
      <div class="contact-us">
        <div class="contact-us-title"><span>Contact Us</span><div class="github-logo"></div></div>
        <div class="github-urls">
          <p>김성윤 : <a href="#">https://github.com/cafephilia</a></p>
          <p>김정학 : <a href="#">https://github.com/</a></p>
          <p>오세영 : <a href="#">https://github.com/seyoung0314</a></p>
          <p>유안준 : <a href="#">https://github.com/</a></p>
        </div>
      </div>
      <div class="policies">
        <a href="#">이용약관</a>
        <a href="#">개인정보처리방침</a>
        <a href="#">운영정책</a>
        <a href="#">위치기반서비스 이용약관</a>
        <a href="#">이용자보호정책</a>
      </div>
    </div>
  </footer>
  <div class="modal-overlay"></div>
    <!-- 배경 레이어 -->
    <div class="modal-content"></div>
</body>
</html>