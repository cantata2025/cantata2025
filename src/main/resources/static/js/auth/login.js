// 로그인 form 가져오기
const $loginForm = document.querySelector(".auth-form");
const $emailInput = document.querySelector('input[name="username"]');


// 서버와 통신하여 로그인 검증을 수행
async function handleLogin(e) {
  e.preventDefault();

  // 사용자가 입력한 유저네임과 비밀번호를 가져옴
  const username = $loginForm.querySelector("input[name=username]").value;
  const password = $loginForm.querySelector("input[name=password]").value;

  // 서버로 보낼 데이터
  const payload = {
    username,
    password,
  };

  // API 통신 보내기
  const response = await fetch("/api/cantata/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(payload),
  });

  const data = await response.json();

  // 로그인이 성공할 시 처리
  if (response.ok) {
    // 브라우저 저장소에 토큰을 저장시킴
    localStorage.setItem("accessToken", data.accessToken);

    // 홈화면으로 이동
    window.location.href = "/";
  } else {
    alert(data.message);
  }
}

function initLogin() {
  // 가입후 정보 가져오기
  const savedEmail = localStorage.getItem("signupEmail") || "";
  $emailInput.value = savedEmail;

  // 커서 비밀번호 인풋창에 위치하게
  document.querySelector('input[name="password"]').focus();

  $loginForm.addEventListener("submit", handleLogin);
}

document.addEventListener("DOMContentLoaded", initLogin);
