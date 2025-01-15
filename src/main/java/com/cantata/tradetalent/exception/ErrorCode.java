package com.cantata.tradetalent.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// API에서 나오는 에러상황들을 상수로 표현
@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    // 알 수 없는 서버오류
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"알 수 없는 서버 오류입니다. 점검 후 조치하겠습니다."),

    TEST_ERROR(HttpStatus.BAD_REQUEST,"테스트용 에러입니다."),

    // 회원 관련 에러
    INVALID_SIGNUP_DATA(HttpStatus.BAD_REQUEST, "잘못된 회원가입 데이터입니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다."),
    DUPLICATE_PHONE(HttpStatus.CONFLICT, "이미 사용 중인 전화번호입니다."),
    DUPLICATE_USERNAME(HttpStatus.CONFLICT, "이미 사용 중인 사용자 이름입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),

    // 인증 관련
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다."),
    ;

    private final HttpStatus status;
    private final String message;


}