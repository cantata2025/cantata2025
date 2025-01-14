// 유효성 검사 함수
function validateForm() {
  const email = document.querySelector("input[type='email']").value;
  const password = document.querySelector("input[type='password']").value;
  if (!email.includes("@")) {
    alert("올바른 이메일을 입력해주세요.");
    return false;
  }
  if (password.length < 6) {
    alert("비밀번호는 최소 6자 이상이어야 합니다.");
    return false;
  }
  return true;
}

document.getElementById("next-button").addEventListener("click", function () {
  // 유효성 검사 통과 시에만 다음 단계 진행
  if (!validateForm()) return;

  const container = document.getElementById("signup-container");

  // HTML 템플릿 가져오기
  const additionalInfoTemplate = document.getElementById("additional-info-template").content.cloneNode(true);
  const modalTemplate = document.getElementById("modal-template").content.cloneNode(true);

  // 기존 콘텐츠 삭제 및 새로운 폼 추가
  container.innerHTML = "";
  container.appendChild(additionalInfoTemplate);
  container.appendChild(modalTemplate);

  // 데이터
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

  // 모달 관련 요소 가져오기
  const modal = document.getElementById("modal");
  const modalCloseBtn = document.getElementById("modal-close-btn");
  const modalBackBtn = document.getElementById("modal-back-btn");
  const skillInput = document.getElementById("skill-input");
  const wantInput = document.getElementById("want-input");
  const skillModalBtn = document.getElementById("skill-modal-btn");
  const wantModalBtn = document.getElementById("want-modal-btn");
  const categoryList = document.getElementById("category-list");
  const subcategoryList = document.getElementById("subcategory-list");
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
        .map((sub) => `<li>${sub}</li>`)
        .join("");
      subcategoryList.classList.remove("hidden");

      // 대분류 목록 숨기기
      categoryList.classList.add("hidden");

      // 뒤로가기 버튼 표시
      modalBackBtn.classList.remove("hidden");

      // 소분류 선택 이벤트
      subcategoryList.addEventListener("click", (e) => {
        if (e.target.tagName === "LI") {
          if (activeInput) {
            activeInput.value = `${category} - ${e.target.textContent}`;
            modal.classList.add("hidden");
          }
        }
      });
    }
  });

  // 뒤로가기 버튼 클릭 이벤트
  modalBackBtn.addEventListener("click", () => {
    // 소분류 목록 숨기기
    subcategoryList.classList.add("hidden");

    // 대분류 목록 다시 표시
    categoryList.classList.remove("hidden");

    // 뒤로가기 버튼 숨기기
    modalBackBtn.classList.add("hidden");
  });

  // 완료 버튼 클릭 이벤트 추가
  document.getElementById("complete-button").addEventListener("click", function () {
    const container = document.getElementById("signup-container");
    container.innerHTML = `
      <h1>회원가입 완료</h1>
      <p>축하합니다! 회원가입이 완료되었습니다.</p>
      <p>잠시 후 로그인 페이지로 이동합니다...</p>
    `;
    setTimeout(() => {
      location.href = "./로그인.html";
    }, 2000);
  });
});