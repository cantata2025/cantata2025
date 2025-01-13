const $contents = document.querySelectorAll('.content');
const $modalOverlay = document.querySelector('.modal-overlay');
const $modalContent = document.querySelector('.modal-content');
const $deleteBtn = document.getElementById('delete');
const $messageContent = document.getElementById('message-content');
const $closeBtn = document.querySelector('.fa-times');
$contents.forEach(content=>{
  content.addEventListener('click',e=>{
    modalOpen(e);
  })
})
function modalOpen(e){
  $modalOverlay.style.display = 'block';
  $modalContent.style.display = 'block';
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
  if(document.querySelectorAll('.board-item').length===0){
    const $newDiv = document.createElement('div');
    $newDiv.classList.add('board-empty');
    $newDiv.textContent = '받은 메시지가 없습니다.'
    document.querySelector('.board').appendChild($newDiv);
  }
}