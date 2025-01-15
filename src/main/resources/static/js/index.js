const sampleJson = {
  "postList": [
      {
          "id": 2,
          "regionName": "수도권",
          "provinceName": "서울특별시",
          "districtName": "광진구",
          "categoryNameGive": "영어",
          "categoryNameTake": "독일어",
          "content": "테스트용 내용2",
          "writer": "aaa@aaa.com",
          "viewCount": 0,
          "createdAt": "2025-01-13T18:34:13"
      },
      {
          "id": 6,
          "regionName": "수도권",
          "provinceName": "경기도",
          "districtName": "구리시",
          "categoryNameGive": "수영",
          "categoryNameTake": "테니스",
          "content": "post맨 테스트2",
          "writer": "bbb@bbb.com",
          "viewCount": 0,
          "createdAt": "2025-01-14T14:12:50"
      },
      {
          "id": 7,
          "regionName": "수도권",
          "provinceName": "경기도",
          "districtName": "구리시",
          "categoryNameGive": "수영",
          "categoryNameTake": "테니스",
          "content": "post맨 테스트2",
          "writer": "bbb@bbb.com",
          "viewCount": 0,
          "createdAt": "2025-01-14T14:16:59"
      },
      {
          "id": 8,
          "regionName": "수도권",
          "provinceName": "경기도",
          "districtName": "구리시",
          "categoryNameGive": "수영",
          "categoryNameTake": "테니스",
          "content": "post맨 테스트2",
          "writer": "bbb@bbb.com",
          "viewCount": 0,
          "createdAt": "2025-01-14T14:17:05"
      },
      {
          "id": 9,
          "regionName": "수도권",
          "provinceName": "경기도",
          "districtName": "구리시",
          "categoryNameGive": "수영",
          "categoryNameTake": "테니스",
          "content": "post맨 테스트2",
          "writer": "bbb@bbb.com",
          "viewCount": 0,
          "createdAt": "2025-01-14T14:22:47"
      }
  ],
  "message": "search success"
}
const $lessons = document.querySelectorAll('.lesson');
const $modalOverlay = document.querySelector('.modal-overlay');
const $modalContent = document.querySelector('.modal-content');
const $renderArea = document.getElementById('lessons');
$lessons.forEach(lesson=>{
  lesson.addEventListener('click',e=>{
    modalOpen(e);
  })
})
$modalOverlay.addEventListener('click',()=>{
  closeModal();
})
function modalOpen(e){
  $modalOverlay.style.display = 'block';
  $modalContent.style.display = 'block';
  renderModal(e);
}
function closeModal(){
  $modalOverlay.style.display = 'none';
  $modalContent.style.display = 'none';
}
function renderModal(e){
  return `
    
  `
}
// 서버에서 포스트 불러오기
async function fetchLessons() {
  const response = await fetch('/api/cantata/post');
  if (!response.ok) {
    alert('목록을 불러오는데 실패했습니다!');
    return sampleJson;
  }
  return await response.json();
}
//받은 데이터로 카드 태그 그리기
function createLessons(id,provinceName,categoryNameGive,categoryNameTake,content,writer,viewCount,createdAt){
  return `
    <li class="lesson" data="${id}">
          <div class="skills"><div class="give">#${categoryNameGive}</div><div class="take">#${categoryNameTake}</div></div>
          <div class="writer">${writer}</div>
          <div class="post-content">${content}</div>
          <div class="location"><i class="fas fa-map-marker-alt"></i> ${provinceName}</div>
          <div class="view-count">${viewCount} <i class="fas fa-eye"></i></div>
        </li>
  `
};
async function renderLessons(){
  // post 데이터를 서버로부터 불러오기
  const lessonList = await fetchLessons();
  $renderArea.innerHTML = lessonList.postList.map(post => 
    createLessons(
      post.id, 
      post.provinceName, 
      post.categoryNameGive, 
      post.categoryNameTake, 
      post.content, 
      post.writer, 
      post.viewCount, 
      post.createdAt
    )
  ).join("");
}
renderLessons();