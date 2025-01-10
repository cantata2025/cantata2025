const subCategories = {
  language: ["영어", "일본어", "중국어", "프랑스어", "독일어", "스페인어", "한국어", "러시아어", "이태리어", "태국어", "베트남어", "그리스어"],
  music: ["피아노", "재즈", "기타", "베이스", "바이올린", "첼로", "플롯", "오보에", "섹소폰", "드럼", "클라리넷", "국악", "보컬"],
  life: ["미술", "요리", "일러스트", "디자인", "꽃", "공예", "패션", "캘리그라피"],
  it: ["영상편집", "프로그래밍", "포토샵", "MS오피스", "3D/캐드"],
  expert: ["심리학", "역사학", "의학", "경제학", "철학", "물리학", "경영학", "마케팅"],
  sports: ["수영", "헬스", "요가/필라테스", "골프", "테니스", "승마", "스키", "볼링"],
  education: ["학습지도", "언어학습", "유아교육/놀이", "직업/커리어 상담", "시험/자격증 준비"],
  perform: ["연기", "마술", "디제잉", "댄스", "스쿠버다이빙", "스케이트보드"]
};

const $buttons = document.querySelectorAll('.category');
const $skillReceive = document.getElementById('skill-receive');

$buttons.forEach(category => {
  category.addEventListener('click', e => {
    e.preventDefault();
    const categoryId = category.id;
    const subCategoryList = subCategories[categoryId];

    $skillReceive.innerHTML = '';

    subCategoryList.forEach((subCategory, index) => {
      const $newButton = document.createElement('button');
      $newButton.classList.add('skill');
      $newButton.textContent = subCategory;

      setTimeout(() => {
        $newButton.classList.add('appear');
      }, index * 10);

      $skillReceive.appendChild($newButton);
    });
  });
});