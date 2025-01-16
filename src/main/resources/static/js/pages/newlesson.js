import { fetchWithAuth } from "../ui/api.js";

// 하위 카테고리 데이터
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
const area = {
  "수도권" :{
      "서울특별시" : [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ],
      "경기도" : [ "수원시 장안구", "수원시 권선구", "수원시 팔달구", "수원시 영통구", "성남시 수정구", "성남시 중원구", "성남시 분당구", "의정부시", "안양시 만안구", "안양시 동안구", "부천시", "광명시", "평택시", "동두천시", "안산시 상록구", "안산시 단원구", "고양시 덕양구", "고양시 일산동구",
          "고양시 일산서구", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시 처인구", "용인시 기흥구", "용인시 수지구", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시", "연천군", "가평군",
          "양평군" ],
      "인천광역시" : [ "계양구", "미추홀구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군" ]			
  },
  "강원권" :{
      "강원도" : [ "춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군" ]			
  },
  "충청권" :{
      "충청북도" : [ "청주시 상당구", "청주시 서원구", "청주시 흥덕구", "청주시 청원구", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군", "괴산군", "음성군", "단양군" ],
      "충청남도" : [ "천안시 동남구", "천안시 서북구", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군" ],
      "대전광역시" : [ "대덕구", "동구", "서구", "유성구", "중구" ],
      "세종특별자치시" : [ "세종특별자치시" ]			
  },
  "전라권" :{
      "전라북도" : [ "전주시 완산구", "전주시 덕진구", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군" ],
      "전라남도" : [ "목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군" ],
      "광주광역시" : [ "광산구", "남구", "동구", "북구", "서구" ]			
  },
  "경상권" : {
      "경상북도" : [ "포항시 남구", "포항시 북구", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군" ],
      "경상남도" : [ "창원시 의창구", "창원시 성산구", "창원시 마산합포구", "창원시 마산회원구", "창원시 진해구", "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군" ],
      "부산광역시" : [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군" ],
      "대구광역시" : [ "남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군" ],
      "울산광역시" : [ "남구", "동구", "북구", "중구", "울주군" ]			
  },
  "제주권" : {
      "제주특별자치도" : [ "서귀포시", "제주시" ]			
  }
};
const $giveButtons = document.querySelectorAll('.category.give');
const $receiveButtons = document.querySelectorAll('.category.receive');
const $skillGive = document.getElementById('skill-give');
const $skillReceive = document.getElementById('skill-receive');
const $area1 = document.getElementById('area1');
const $area2 = document.getElementById('area2');
const $area3 = document.getElementById('area3');
const $selectedGive = document.getElementById('selected-give');
const $selectedReceive = document.getElementById('selected-receive');


let giveCheck;
let receiveCheck;

function renderSubCategories(container, categoryId) {
  const subCategoryList = subCategories[categoryId] || [];
  container.innerHTML = '';

  subCategoryList.forEach((subCategory, index) => {
    const $newButton = document.createElement('button');
    $newButton.classList.add('skill');
    $newButton.textContent = subCategory;

    setTimeout(() => {
      $newButton.classList.add('appear');
    }, index * 5);

    container.appendChild($newButton);
  });
}
//이벤트 리스너들
$giveButtons.forEach(button => {
  button.addEventListener('click', e => {
    e.preventDefault();
    $giveButtons.forEach(button=>button.classList.remove('category-selected'));
    e.target.classList.add('category-selected');
    const categoryId = button.id;
    renderSubCategories($skillGive, categoryId);
    addSelectEvent();
  });
});

$receiveButtons.forEach(button => {
  button.addEventListener('click', e => {
    e.preventDefault();
    $receiveButtons.forEach(button=>button.classList.remove('category-selected'));
    e.target.classList.add('category-selected');
    const categoryId = button.id;
    renderSubCategories($skillReceive, categoryId);
    addSelectEvent();
  });
});
function addSelectEvent(){
  const $giveSkills = document.getElementById('skill-give').querySelectorAll('.skill');
  const $receiveSkills = document.getElementById('skill-receive').querySelectorAll('.skill');
  $giveSkills.forEach(skill=>{
  skill.addEventListener('click',e=>{
    e.preventDefault();
    $giveSkills.forEach(skill=>{
      skill.classList.remove('selected');
    })
    e.target.classList.add('selected');
    giveCheck=e.target.textContent;
    renderSelectedBtn(giveCheck,'give');
  })
})
  $receiveSkills.forEach(skill=>{
    skill.addEventListener('click',e=>{
      e.preventDefault();
      $receiveSkills.forEach(skill=>{
        skill.classList.remove('selected');
      })
      e.target.classList.add('selected');
      receiveCheck=e.target.textContent;
      renderSelectedBtn(receiveCheck,'receive');
  })
})
}
function renderSelectedBtn(checked,type){
  const $newDiv = document.createElement('div');
  $newDiv.textContent=checked;
  if(type==='give'){
    $selectedGive.innerHTML ='';
    $selectedGive.appendChild($newDiv);
  }
  if(type==='receive'){
    $selectedReceive.innerHTML ='';
    $selectedReceive.appendChild($newDiv);
  }
}
// 지역선택 버튼 만드는 함수
function renderArea1Select(){
  Object.keys(area).forEach(area=>{
    const $newOption = document.createElement('option');
    $newOption.textContent = area;
    $newOption.setAttribute('value',area);
    $area1.appendChild($newOption);
  })
}
function renderArea2Select(){
  $area1.addEventListener('change',e=>{
    // area2 초기화
    $area2.querySelectorAll('option').forEach((option,index)=>{
      if(index!==0) option.remove();
    })
    // area3 초기화
    $area3.querySelectorAll('option').forEach((option,index)=>{
      if(index!==0) option.remove();
    })
    Object.keys(area[e.target.value]).forEach(area=>{
      const $newOption = document.createElement('option');
      $newOption.textContent = area;
      $newOption.setAttribute('value',area);
      $area2.appendChild($newOption);
    })
  })
}
function renderArea3Select(){
  $area2.addEventListener('change',e=>{
    // area3 초기화
    $area3.querySelectorAll('option').forEach((option,index)=>{
      if(index!==0) option.remove();
    })
    area[$area1.value][e.target.value].forEach(area=>{
      const $newOption = document.createElement('option');
      $newOption.textContent = area;
      $newOption.setAttribute('value',area);
      $area3.appendChild($newOption);
    })
  })
}
// 초기실행 영역
document.addEventListener('DOMContentLoaded',()=>{
  renderArea1Select();
  renderArea2Select();
  renderArea3Select();
})
//작성하기 버튼 누르면
document.getElementById('submit').addEventListener('click', e=>{
  e.preventDefault();
  if($area3.value==='' || $selectedGive==='' || $selectedReceive===''){
    alert('위치/과목은 필수입니다!')
  }else{
    const area1 = $area1.value;
    const area2 = $area2.value;
    const area3 = $area3.value;
    const giveCategory = $selectedGive.textContent;
    const receiveCategory = $selectedReceive.textContent;
    const contentText = document.getElementById('content').value;
    const newLessonData = {
        area1: area1,//광역
        area2: area2,//시도
        area3: area3,//시구군
        giveCategory: giveCategory,
        receiveCategory: receiveCategory,
        contentText: contentText,
    }
    fetchToNewLesson(newLessonData);
    console.log(newLessonData);
  }
})
// 새로운 개설 정보를 서버로 전송
async function fetchToNewLesson(newLessonData) {
  const response = await fetchWithAuth('/api/cantata/post', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(newLessonData)
  });

  const data = await response.json();
  
  alert('정상적으로 게시되었습니다!');
  window.location.href = '/'; // 인덱스로 이동
}