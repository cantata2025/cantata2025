package com.cantata.tradetalent.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;



@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // ErrorResponse 생성하는 공통 메서드
    private ErrorResponse createErrorResponse
    (Exception e, HttpServletRequest request, HttpStatus status, String errorMessage) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.name())
                .message(errorMessage != null ? errorMessage : e.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    //커스텀 에러 처리
    //throw new MemberException(ErrorCode.TEST_ERROR,"10자 이하"); 로 던짐
//    @ExceptionHandler(MemberException.class)
//    public ResponseEntity<?> handleCustomException(MemberException e, HttpServletRequest request) {
//        log.error("Customer error occurred: {}", e.getMessage(), e);
//
//        ErrorResponse response = createErrorResponse
//                (e, request, e.getErrorCode().getStatus(), e.getMessage());
//
//        return ResponseEntity
//                .status(e.getErrorCode().getStatus())
//                .body(response);
//    }

    //알 수 없는 에러들을 일괄 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e, HttpServletRequest request) {
        log.error("Unexpected error occurred: {}", e.getMessage(), e);

        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR.getMessage());

        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(response);
    }


    // 입력값 검증 예외처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("Validation error occurred: {}", e.getMessage(), e);

        String errorMessage = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.BAD_REQUEST, errorMessage);

        return ResponseEntity
                .status(e.getStatusCode())
                .body(response);
    }

    // 인증 실패 예외 처리
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException e, HttpServletRequest request) {
        log.error("Authentication error occurred: {}", e.getMessage(), e);
        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.UNAUTHORIZED, "Authentication failed");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // 회원 관련
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(
            UserException e, HttpServletRequest request) {

        log.error("UserException occurred: {}", e.getMessage(), e);

        ErrorResponse response = createErrorResponse
                (e, request, e.getErrorCode().getStatus(), e.getMessage());
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(response);
    }

    // 권한 부족 예외 처리 (커스텀처리)
//    @ExceptionHandler(AuthorizationException.class)
//    public ResponseEntity<?> handleAuthorizationException(AuthorizationException e, HttpServletRequest request) {
//        log.error("Authorization error occurred: {}", e.getMessage(), e);
//        ErrorResponse response = createErrorResponse
//                (e, request, HttpStatus.FORBIDDEN, "Access denied");
//        return ResponseEntity
//                .status(response.getStatus())
//                .body(response);
//    }

    // 엔티티가 존재하지 않는 경우 처리
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
        log.error("Entity not found: {}", e.getMessage(), e);
        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.NOT_FOUND, "Entity not found");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // 파라미터 타입 불일치 예외 처리
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        log.error("Argument type mismatch: {}", e.getMessage(), e);
        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.BAD_REQUEST, "Invalid parameter type");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // HTTP 메시지 파싱 오류 처리
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.error("HTTP message not readable: {}", e.getMessage(), e);

        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.BAD_REQUEST, "Invalid JSON or request body");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // 파일 업로드 예외 처리
    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<?> handleFileUploadException(FileUploadException e, HttpServletRequest request) {
        log.error("File upload error occurred: {}", e.getMessage(), e);
        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.BAD_REQUEST, "File upload failed");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    // 접근 제한 예외 처리
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        log.error("Access denied: {}", e.getMessage(), e);
        ErrorResponse response = createErrorResponse
                (e, request, HttpStatus.FORBIDDEN, "Access denied");
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }
}