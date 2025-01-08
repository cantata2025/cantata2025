package com.cantata.tradetalent.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private final LocalDateTime timestamp;  //발생시간
    private final int status;   //상태코드
    private final String error; //에러 이름
    private final String message;   //원인 메세지
    private final String path;  //발생경로
}