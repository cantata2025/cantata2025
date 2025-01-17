// src/main/resources/static/js/components/more-menu.js

import { fetchWithAuth } from "../util/api.js";

// 서버에 로그아웃 요청 보내기
async function handleLogout() {

  const response = await fetchWithAuth('/api/auth/logout', {
    method: 'POST'
  });

  if (!response.ok) {
    alert('로그아웃에 실패했습니다.');
    return;
  }

  // 브라우저가 저장한 토큰을 삭제
  localStorage.removeItem('accessToken');

  // 로그인페이지로 리다이렉트
  window.location.href = '/';
}