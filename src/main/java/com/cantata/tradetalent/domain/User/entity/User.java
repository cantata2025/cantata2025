package com.cantata.tradetalent.domain.User.entity;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class User {
    private Long id;  // 기본 키
    private String password;  // 비밀번호
    private String name;  // 사용자 이름
    private String email;  // 이메일, 고유값
    private String profileImageUrl;  // 프로필 이미지 URL
    private LocalDateTime registrationDate;  // 회원가입일
    private LocalDateTime updatedAt;  // 최종 수정일
    private LocalDateTime deactivationDate;  // 회원탈퇴일
}
