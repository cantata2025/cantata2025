<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="css/index.css">
  <script
      src="js/index.js"
      defer
    ></script>
</head>
<body>
  <header>
    <div class="head-container">
      <div class="head-wrap">
        <div class="logo">
          <span>TradeTalent</span>
        </div>
        <ul class="nav">
          <li><a href="#">프로필</a></li>
          <li><a href="#">메세지</a></li>
          <li><a href="#">레슨등록</a></li>
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
      <div class="lessons-info">
        <p>렌더링 샘플</p>
      </div>
      <ul class="lessons" id="lesson-sample">
        <li class="lesson">
          <div class="skills"><div class="give">#영어</div><div class="take">#프로그래밍</div></div>
          <div class="writer">김크리스티아나</div>
          <div class="post-content">
            한영 책 번역 경험있는 14년차 영어강사입니다. 회화위주로 수업진행하고 있습니다. 학습자에게 맞는 학습방법를 같이 찾아내어 학습 중 자연스럽게 일어날 수 있는 영어의 벽을 넘는 방법을 알려드리겠습니다. 학습자가 관심있는 원서를 같이 읽으며 영어로 이야기하는 수업도 진행하고 있습니다.

저는 프로그래밍을 배우고 직접 소프트웨어를 만들어 볼 수 있는 레슨을 찾고있습니다.
          </div>
          <div class="location"><i class="fas fa-map-marker-alt"></i> 부산</div>
          <div class="view-count">35 <i class="fas fa-eye"></i></div>
        </li>
        <li class="lesson">
          <div class="skills"><div class="give">#영어</div><div class="take">#프로그래밍</div></div>
          <div class="writer">김크리스티아나</div>
          <div class="post-content">
            한영 책 번역 경험있는 14년차 영어강사입니다. 회화위주로 수업진행하고 있습니다. 학습자에게 맞는 학습방법를 같이 찾아내어 학습 중 자연스럽게 일어날 수 있는 영어의 벽을 넘는 방법을 알려드리겠습니다. 학습자가 관심있는 원서를 같이 읽으며 영어로 이야기하는 수업도 진행하고 있습니다.

저는 프로그래밍을 배우고 직접 소프트웨어를 만들어 볼 수 있는 레슨을 찾고있습니다.
          </div>
          <div class="location"><i class="fas fa-map-marker-alt"></i> 부산</div>
          <div class="view-count">35 <i class="fas fa-eye"></i></div>
        </li>
        <li class="lesson">
          <div class="skills"><div class="give">#영어</div><div class="take">#프로그래밍</div></div>
          <div class="writer">김크리스티아나</div>
          <div class="post-content">
            한영 책 번역 경험있는 14년차 영어강사입니다. 회화위주로 수업진행하고 있습니다. 학습자에게 맞는 학습방법를 같이 찾아내어 학습 중 자연스럽게 일어날 수 있는 영어의 벽을 넘는 방법을 알려드리겠습니다. 학습자가 관심있는 원서를 같이 읽으며 영어로 이야기하는 수업도 진행하고 있습니다.

저는 프로그래밍을 배우고 직접 소프트웨어를 만들어 볼 수 있는 레슨을 찾고있습니다.
          </div>
          <div class="location"><i class="fas fa-map-marker-alt"></i> 부산</div>
          <div class="view-count">35 <i class="fas fa-eye"></i></div>
        
      </ul>
      <div class="lessons-info">
        <p>렌더링 영역</p>
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
  <div class="modal-content">
    <div class="modal-wrap">
      <div class="modal-head">
        <div class="modal-give">영어</div>
        <div class="modal-take">프로그래밍</div>
      </div>
      <div class="modal-main">
        <div class="modal-text">
          한영 책 번역 경험있는 14년차 영어강사입니다. 회화위주로 수업진행하고 있습니다. 학습자에게 맞는 학습방법를 같이 찾아내어 학습 중 자연스럽게 일어날 수 있는 영어의 벽을 넘는 방법을 알려드리겠습니다. 학습자가 관심있는 원서를 같이 읽으며 영어로 이야기하는 수업도 진행하고 있습니다.

저는 프로그래밍을 배우고 직접 소프트웨어를 만들어 볼 수 있는 레슨을 찾고있습니다.
        </div>
      </div>
      <div class="modal-bottom">
        <div class="modal-location">부산</div>
        <div class="modal-viewcount">10 </div>
      </div>
    </div>
  </div>
</body>
</html>