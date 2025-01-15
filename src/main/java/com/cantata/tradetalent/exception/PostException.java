package com.cantata.tradetalent.exception;

import lombok.Getter;

@Getter
public class PostException extends RuntimeException {
  private final ErrorCode errorCode;

  public PostException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public PostException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
