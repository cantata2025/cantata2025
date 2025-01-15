<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>New Lesson</title>
    <link
      rel="stylesheet"
      href="css/components/newlesson.css"
    />
    <script
      src="js/pages/newlesson.js"
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
        <div class="new-lesson">
          <p>새로운 레슨 개설하기</p>
          <form id="new-lesson-form" novalidate>
            <div class="form-filed">
              <p>레슨을 함께할 위치</p>
              <select id="area1" title="권역선택" class="boardSearch_select">
                <option value="">권역선택</option>
              </select>
              <select id="area2" title="시도선택" class="boardSearch_select">
                <option value="">시도선택</option>
              </select>
              <select id="area3" title="시군구선택" class="boardSearch_select">
                <option value="">시군구선택</option>
              </select>
            </div>
            <div class="form-filed">
              <div>
                <span>가르쳐 줄 과목 &nbsp;&nbsp;&nbsp;:</span>
                <div id="selected-give" class="inline"></div>
              </div>
              <div class="category-container">
                <button class="category give" id="language">외국어</button>
                <button class="category give" id="music">음악</button>
                <button class="category give" id="life">라이프</button>
                <button class="category give" id="it">IT</button>
                <button class="category give" id="expert">전문지식</button>
                <button class="category give" id="sports">스포츠</button>
                <button class="category give" id="education">교육</button>
                <button class="category give" id="perform">공연</button>
            </div>
            <div id="skill-give">
              <!-- 스크립트로 하위 카테고리 호출 -->
            </div>
            <div class="form-filed">
              <div>
                <span>배우고 싶은 과목 :</span>
                <div id="selected-receive" class="inline"></div>
              </div>
              <div class="category-container">
                <button class="category receive" id="language">외국어</button>
                <button class="category receive" id="music">음악</button>
                <button class="category receive" id="life">라이프</button>
                <button class="category receive" id="it">IT</button>
                <button class="category receive" id="expert">전문지식</button>
                <button class="category receive" id="sports">스포츠</button>
                <button class="category receive" id="education">교육</button>
                <button class="category receive" id="perform">공연</button>
              </div>
              <div class="main-category">
              <div id="skill-receive">
                <!-- 스크립트로 하위 카테고리 호출 -->
              </div>
            </div>
            <div class="form-filed">
              <p>전달할 내용</p>
              <textarea
                name="content"
                id="content"
                placeholder="자세한 내용을 작성해 주세요."
              ></textarea>
            </div>
            <div class="submit-container"><button id="submit" type="submit">작성하기</button></div>
          </form>
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
    <div class="modal-content"></div>
  </body>
</html>