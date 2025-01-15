<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="stylesheet"
      href="css/components/message.css"
    />
    <script
      src="js/pages/message.js"
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
        <div id="message-board">
          <p>받은 메세지함</p>
          <div id="delete"><i class="fas fa-times"></i> 삭제하기</div>
          <div class="board">
            <!-- Header -->
            <div class="board-header">
              <div class="check">체크</div>
              <div class="sender">보낸 사람</div>
              <div class="content">내용</div>
              <div class="date">날짜</div>
            </div>
        
            <!-- Item 1 -->
            <div class="board-item">
              <div class="check"><input type="checkbox"></div>
              <div class="sender">폼폼푸린</div>
              <div class="content">샘플 메세지입니다.</div>
              <div class="date">2025-01-13</div>
            </div>
        
            <!-- Item 2 -->
            <div class="board-item">
              <div class="check"><input type="checkbox"></div>
              <div class="sender">쿠루미</div>
              <div class="content">누르면 모달이 나옵니다.</div>
              <div class="date">2025-01-12</div>
            </div>
        
            <!-- Empty message -->
            <!-- Uncomment below if the list is empty -->
            <!--
            <div class="board-empty">
              받은 메시지가 없습니다.
            </div>
            -->
          </div>
        </div>
      </div>
    </main>
    <footer>
      <div class="foot-container">
        <div class="contact-us">
          <div class="contact-us-title">
            <span>Contact Us</span>
            <div class="github-logo"></div>
          </div>
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
    <div class="modal-content">
      <i class="fas fa-times"></i>
      <div><span>보낸사람 : </span><span id="modal-sender"></span></span>
      <p>내용</p>
      <div class="content-box">
        <p id="message-content"></p>
      </div>
      <button id="reply">답장하기</button>
    </div>
    <div class="modal-content modal-right">
      <i class="fas fa-times"></i>
      <div><p>보낸사람 : </p></div>
      <p>내용</p>
      <div class="content-box">
        <p id="message-content"></p>
      </div>
      <button>답장하기</button>
    </div>
  </body>
</html>