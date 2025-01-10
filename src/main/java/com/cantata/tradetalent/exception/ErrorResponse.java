package com.cantata.tradetalent.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Builder

public class ErrorResponse {
    private final LocalDateTime timestamp; // 에러가 발생한 시간
    private final int status;  // 에러 상태코드
    private final String error; // 에러 이름
    private final String message; // 에러 원인 메시지
    private final String path;   // 에러가 발생한 경로
}
