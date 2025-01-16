import { fetchWithAuth } from "./ui/api.js";

const $lessons = document.querySelectorAll('.lesson');
const $modalOverlay = document.querySelector('.modal-overlay');
const $modalContent = document.querySelector('.modal-content');
const $renderArea = document.getElementById('lessons');
document.addEventListener('DOMContentLoaded',()=>{
  //카드를 클릭하면 모달나옴옴
  $renderArea.addEventListener('click', (e) => {
    if (e.target.closest('.lesson')) {
      modalOpen(e);
    }
  });
})
//모달 바깥 클릭하면 꺼짐짐
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
async function renderModal(e){
  const lesson = await fetchLessonById(e.target.closest('.lesson').dataset.id);
  $modalContent.innerHTML = `
    <h2>${lesson.post.categoryNameGive} ⇆ ${lesson.post.categoryNameTake}</h2>
    <p><strong>작성자:</strong> ${lesson.post.writer}</p>
    <p><strong>작성일:</strong> ${new Date(lesson.post.createdAt).toLocaleDateString()}</p>
    <p>${lesson.post.content}</p>
    <div style="display: flex; justify-content: space-between; margin-top: 20px;">
    <span><i class="fas fa-map-marker-alt"></i> ${lesson.post.provinceName}</span>
    <span><i class="fas fa-eye"></i> ${lesson.post.viewCount} 조회</span>
  </div>
  <a href="#" class="close-btn" onclick="closeModal()">답장하기</a>
`;
}
// 서버에서 여러 포스트 불러오기
async function fetchLessons() {
  const response = await fetchWithAuth('/api/cantata/post');
  if (!response.ok) alert('목록을 불러오는데 실패했습니다!');
  return await response.json();
}
// 서버에서 단일 포스트 조회
async function fetchLessonById(id) {
  //조회수 올려줌
  await fetchWithAuth(`/api/cantata/post/view-count?id=${id}`,{
    method:"PUT"
  });
  //포스트 조회
  const response = await fetchWithAuth(`/api/cantata/post/${id}`)
  if (!response.ok) alert('게시글을 조회하는데데 실패했습니다!');
  return await response.json();
  
}
//받은 데이터로 카드 태그 그리기
function createLessons(id,provinceName,categoryNameGive,categoryNameTake,content,writer,viewCount,createdAt){
  return `
    <li class="lesson" data-id="${id}">
          <div class="skills"><div class="give">#${categoryNameGive}</div><div class="take">#${categoryNameTake}</div></div>
          <div class="writer">${writer}</div>
          <div class="post-content">${content}</div>
          <div class="location"><i class="fas fa-map-marker-alt"></i> ${provinceName}</div>
          <div class="view-count">${viewCount} <i class="fas fa-eye"></i></div>
        </li>
  `
};
renderLessons();
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