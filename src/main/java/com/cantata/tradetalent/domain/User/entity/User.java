package com.cantata.tradetalent.domain.User.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
    private Long id;  // 기본 키
    private String password;  // 비밀번호
    private String name;  // 사용자 이름
    private String email;  // 이메일, 고유값
    private String profileImageUrl;  // 프로필 이미지 URL
    private String role;
    private String refreshToken;
    private LocalDateTime registrationDate;  // 회원가입일
    private LocalDateTime updatedAt;  // 최종 수정일
    private LocalDateTime deactivationDate;  // 회원탈퇴일
}
