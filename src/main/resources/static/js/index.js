const $lessons = document.querySelectorAll('.lesson');
const $modalOverlay = document.querySelector('.modal-overlay');
const $modalContent = document.querySelector('.modal-content');
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