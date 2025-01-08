package com.cantata.tradetalent.domain.test.entity;

import java.util.Date;


import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TestGet {
    private int id;                          // 기본 키, 자동 증가
    private String username;                 // 사용자 ID (고유값)
    private String password;                 // 비밀번호
    private String name;                     // 사용자 이름
    private String phoneNumber;              // 연락처 전화번호
    private String email;                    // 이메일 (고유값)
    private Date birthDate;                  // 생년월일
    private char gender;                     // 성별 ('M' 또는 'F')
    private Date registrationDate;           // 회원가입일
    private Date deactivationDate;           // 회원탈퇴일
}
