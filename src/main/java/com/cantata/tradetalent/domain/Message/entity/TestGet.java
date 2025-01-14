package com.cantata.tradetalent.domain.Message.entity;

import java.time.LocalDateTime;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TestGet {
    private int id;                     // 기본 키 (ID)
    private String password;            // 비밀번호
    private String name;                // 사용자 이름
    private String email;               // 이메일 (고유값)
    private String profileImageUrl;     // 프로필 이미지 URL
    private LocalDateTime registrationDate; // 회원가입일
    private LocalDateTime updatedAt;        // 마지막 수정일
    private LocalDateTime deactivationDate; // 회원탈퇴일 (null 가능)
}
