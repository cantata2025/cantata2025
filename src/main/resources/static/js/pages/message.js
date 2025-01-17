// import { fetchWithAuth } from "../util/api.js";

const $contents = document.querySelectorAll('.content');
const $modalOverlay = document.querySelector('.modal-overlay');
const $modalContent = document.querySelector('.modal-content');
const $deleteBtn = document.getElementById('delete');
const $messageContent = document.getElementById('message-content');
const $closeBtn = document.querySelector('.fa-times');
const $sender = document.getElementById('modal-sender');
$contents.forEach(content=>{
  content.addEventListener('click',e=>{
    modalOpen(e);
  })
})
function modalOpen(e){
  $modalOverlay.style.display = 'block';
  $modalContent.style.display = 'block';
  console.log(e.target.closest('.board-item').querySelector('.sender').textContent)
  console.log($sender)
  $sender.textContent = e.target.closest('.board-item').querySelector('.sender').textContent;
  $messageContent.textContent = e.target.textContent;
}
//모달 닫기
$modalContent.addEventListener('click',e=>{
  if(!e.target.matches('.fa-times')) return;
    closeModal();
})
$modalOverlay.addEventListener('click',()=>{
  closeModal();
})
function closeModal(){
  $modalOverlay.style.display = 'none';
  $modalContent.style.display = 'none';
  $sender.textContent='';
  $messageContent.textContent='';
}
// 삭제버튼
$deleteBtn.addEventListener('click',e=>{
  document.querySelectorAll('input[type="checkbox"]').forEach(check=>{
    if(check.checked)
      check.closest('.board-item').remove();
  })
  displayEmpty();
})
// 표시할 내용이 없을 때
function displayEmpty(){
  if(document.querySelectorAll('.board-empty').length===1) return;
  if(document.querySelectorAll('.board-item').length===0){
    const $newDiv = document.createElement('div');
    $newDiv.classList.add('board-empty');
    $newDiv.textContent = '받은 메시지가 없습니다.'
    document.querySelector('.board').appendChild($newDiv);
  }
}
function createMessageItem({sender,content,date}){
  return `
    <div class="board-item">
      <div class="check"><input type="checkbox"></div>
      <div class="sender">/${sender}</div>
      <div class="content">/${content}</div>
      <div class="date">/${date}</div>
    </div>
  `
}
// 메세지를 서버에서 불러오기
async function fetchMessages() {

  // 서버 요청시 토큰을 헤더에 포함해서 요청
  const response = await fetchWithAuth('/api/cantata/message/receive');
  if (!response.ok) alert('메세지 목록을 불러오는데 실패했습니다.');
  return await response.json();
}

//렌더링
async function renderMessage(){
  const messageList = await fetchMessages();
}