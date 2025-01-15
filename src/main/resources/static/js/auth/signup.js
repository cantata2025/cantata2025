const container = document.getElementById("signup-container");
const container2 = document.getElementById("signup-container2");
document.addEventListener("DOMContentLoaded", () => {
  const emailInput = document.getElementById("email-input");
  const nicknameInput = document.getElementById("nickname-input");
  const passwordInput = document.getElementById("password-input");
  const nextButton = document.getElementById("next-button");

  const emailError = document.getElementById("email-error");
  const nicknameError = document.getElementById("nickname-error");
  const passwordError = document.getElementById("password-error");
  const container = document.getElementById("signup-container");
  const container2 = document.getElementById("signup-container2");

  // 로컬 스토리지에서 기존 데이터 가져오기
  const savedEmail = localStorage.getItem("signupEmail") || "";
  const savedNickname = localStorage.getItem("signupNickname") || "";
  const savedPassword = localStorage.getItem("signupPassword") || "";

  // 데이터 복원
  emailInput.value = savedEmail;
  nicknameInput.value = savedNickname;
  passwordInput.value = savedPassword;

  // 입력값 확인 함수
  function validateInputs() {
    let isValid = true;

    if (!emailInput.value.includes("@")) {
      emailError.textContent = "유효한 이메일 주소를 입력해주세요.";
      isValid = false;
    } else {
      emailError.textContent = "";
    }

    if (nicknameInput.value.trim() === "") {
      nicknameError.textContent = "별명을 입력해주세요.";
      isValid = false;
    } else {
      nicknameError.textContent = "";
    }

    if (passwordInput.value.length < 6) {
      passwordError.textContent = "비밀번호는 최소 6자 이상이어야 합니다.";
      isValid = false;
    } else {
      passwordError.textContent = "";
    }

    return isValid;
  }
  let count = 0;
  // '다음' 버튼 클릭 이벤트
  nextButton.addEventListener("click", () => {
    if (!validateInputs()) return;

    // 데이터 저장
    localStorage.setItem("signupEmail", emailInput.value);
    localStorage.setItem("signupNickname", nicknameInput.value);
    localStorage.setItem("signupPassword", passwordInput.value);

    // HTML 템플릿 가져오기
    const additionalInfoTemplate = document.getElementById("additional-info-template").content.cloneNode(true);
    const modalTemplate = document.getElementById("modal-template").content.cloneNode(true);

    // 기존 콘텐츠 숨기기 및 새로운 폼 추가
    // container의 html 비우기에서 숨기기로 전환됨, 추가정보 페이지는 한번만 생성됨
    container.classList.toggle('hidden');
    if(count===0){
      container2.appendChild(additionalInfoTemplate);
      container2.appendChild(modalTemplate);
      initializeAdditionalInfoModal(container2);
      initBackLink();
      count++
    }
    container2.classList.toggle('hidden');
    

    
  });

  // 모달 및 추가 정보 폼 초기화 함수
  function initializeAdditionalInfoModal(container) {
    const categories = {
      "외국어": ["영어", "일본어", "중국어", "프랑스어", "독일어", "스페인어", "한국어", "러시아어", "이태리어", "태국어", "베트남어", "그리스어"],
      "음악": ["피아노", "재즈", "기타", "베이스", "바이올린", "첼로", "플롯", "오보에", "섹소폰", "드럼", "클라리넷", "국악", "보컬", "성악", "작곡", "화성학", "미디"],
      "라이프": ["미술", "요리", "일러스트", "디자인", "꽃", "공예", "패션", "캘리그라피"],
      "IT": ["영상편집", "프로그래밍", "포토샵", "MS오피스", "3D/캐드"],
      "전문지식": ["심리학", "역사학", "의학", "경제학", "철학", "물리학", "경영학", "마케팅"],
      "스포츠": ["수영", "헬스", "요가/필라테스", "골프", "테니스", "승마", "스키", "볼링"],
      "교육": ["학습지도", "언어학습", "유아교육/놀이", "직업/커리어 상담", "시험/자격증 준비"],
      "공연": ["연기", "마술", "디제잉", "댄스", "스쿠버다이빙", "스케이트보드"]
    };

    const modal = container.querySelector("#modal");
    const modalCloseBtn = container.querySelector("#modal-close-btn");
    const modalBackBtn = container.querySelector("#modal-back-btn");
    const skillInput = container.querySelector("#skill-input");
    const wantInput = container.querySelector("#want-input");
    const skillModalBtn = container.querySelector("#skill-modal-btn");
    const wantModalBtn = container.querySelector("#want-modal-btn");
    const categoryList = container.querySelector("#category-list");
    const subcategoryList = container.querySelector("#subcategory-list");
    let activeInput = null;

    // 모달 열기
    skillModalBtn.addEventListener("click", () => {
      modal.classList.remove("hidden");
      categoryList.classList.remove("hidden");
      subcategoryList.classList.add("hidden");
      modalBackBtn.classList.add("hidden");
      activeInput = skillInput;
    });

    wantModalBtn.addEventListener("click", () => {
      modal.classList.remove("hidden");
      categoryList.classList.remove("hidden");
      subcategoryList.classList.add("hidden");
      modalBackBtn.classList.add("hidden");
      activeInput = wantInput;
    });

    // 모달 닫기
    modalCloseBtn.addEventListener("click", () => {
      modal.classList.add("hidden");
      activeInput = null;
    });

    // 대분류 클릭 이벤트
categoryList.addEventListener("click", (e) => {
  const category = e.target.dataset.category;

  if (category && categories[category]) {
    // 소분류 목록 업데이트
    subcategoryList.innerHTML = categories[category]
      .map((sub) => `<li data-category="${category}">${sub}</li>`)
      .join("");
    subcategoryList.classList.remove("hidden");

    // 대분류 목록 숨기기
    categoryList.classList.add("hidden");

    // 뒤로가기 버튼 표시
    modalBackBtn.classList.remove("hidden");
  }
});

// 소분류 클릭 이벤트
subcategoryList.addEventListener("click", (e) => {
  if (e.target.tagName === "LI") {
    const category = e.target.dataset.category; // 대분류 가져오기
    const subcategory = e.target.textContent; // 소분류 가져오기

    if (activeInput) {
      activeInput.value = `${category} - ${subcategory}`; // 대분류 - 소분류 형태로 설정
      modal.classList.add("hidden");
    }
  }
});


    // 뒤로가기 버튼 클릭 이벤트
    modalBackBtn.addEventListener("click", () => {
      subcategoryList.classList.add("hidden");
      categoryList.classList.remove("hidden");
      modalBackBtn.classList.add("hidden");
    });

    // 완료 버튼 클릭 이벤트
    container.querySelector("#complete-button").addEventListener("click", e => {
      e.preventDefault(); // 폼 전송시 발생하는 새로고침 방지

      // 사용자가 입력한 모든 입력값 읽어오기
      const email = document.getElementById('email-input').value;
      const name = document.getElementById('nickname-input').value;
      const password = document.getElementById('password-input').value;

      const payload = {
        email: email,
        name: name,
        password: password,
      };

    // 서버로 데이터 전송
    fetchToSignUp(payload);
      container.innerHTML = `
        <h1>회원가입 완료</h1>
        <p>축하합니다! 회원가입이 완료되었습니다.</p>
        <p>잠시 후 로그인 페이지로 이동합니다...</p>
      `;
      setTimeout(() => {
        location.href = "/";
      }, 2000);
    });
  }
});
//이전 단계로 돌아가고싶나요? 이전 단계 <--이거 클릭시
function initBackLink(){
  const $backLink = document.getElementById('back-link');
  $backLink.addEventListener('click',e=>{
    e.preventDefault();
    container.classList.toggle('hidden');
    container2.classList.toggle('hidden');
  })
}

async function fetchToSignUp(userData) {

  const response = await fetch('/api/cantata/auth/signup', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(userData)
  });

  const data = await response.json();
  
  // window.location.href = '/'; // 로그인 페이지 이동
}


