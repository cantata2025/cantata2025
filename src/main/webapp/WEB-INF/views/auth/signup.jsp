<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>가입</title>
  <link rel="stylesheet" href="css/auth/signup.css">
<script src="js/auth/signup.js" type="module" defer></script>
</head>
<body>
  <div class="signup-container" id="signup-container">
    <h1>가입하기</h1>
    <p>간편하게 수업을 찾고 공유하려면 가입하세요.</p>
    <form id="signup-form">
      <input id="email-input" type="email" placeholder="이메일" required>
      <small id="email-error" class="error-message"></small>

      <input id="nickname-input" type="text" placeholder="별명" required>
      <small id="nickname-error" class="error-message"></small>

      <input id="password-input" type="password" placeholder="비밀번호" required>
      <small id="password-error" class="error-message"></small>

      <button type="button" id="next-button">다음</button>
    </form>
    <p>계정이 있으신가요? <a href="/login">로그인</a></p>
  </div>
  <div class="signup-container hidden" id="signup-container2">

  </div>
  <!-- 모달 및 추가 폼 템플릿 -->
  <template id="additional-info-template">
    <h1>추가 정보 입력</h1>
    <p>잘하는 분야와 배우고 싶은 분야를 입력해주세요.</p>
    <form id="additional-info-form">
      <input id="skill-input" type="text" placeholder="잘하는 분야" readonly>
      <button type="button" id="skill-modal-btn">잘하는 분야 선택</button>

      <input id="want-input" type="text" placeholder="배우고 싶은 분야" readonly>
      <button type="button" id="want-modal-btn">배우고 싶은 분야 선택</button>

      <button type="button" id="complete-button">완료</button>
    </form>
    <p>이전 단계로 돌아가고 싶으신가요? <a href="#" id="back-link">이전 단계</a></p>
  </template>

  <template id="modal-template">
    <div id="modal" class="modal hidden">
      <div class="modal-content">
        <h2>분야 선택</h2>
        <ul id="category-list">
          <li data-category="외국어">외국어</li>
          <li data-category="음악">음악</li>
          <li data-category="라이프">라이프</li>
          <li data-category="IT">IT</li>
          <li data-category="전문지식">전문지식</li>
          <li data-category="스포츠">스포츠</li>
          <li data-category="교육">교육</li>
          <li data-category="공연">공연</li>
        </ul>
        <ul id="subcategory-list" class="hidden"></ul>
        <button id="modal-back-btn" class="hidden">뒤로가기</button>
        <button id="modal-close-btn">닫기</button>
      </div>
    </div>
  </template>

</body>
</html>