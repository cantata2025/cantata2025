package com.cantata.tradetalent.domain.User.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DuplicateCheckResponse {
    private boolean available;
    private  String message;  // 중복검사 결과 메세지

    // 사용 가능할 경우 객체생성 메서드
    public static DuplicateCheckResponse available(){
        return DuplicateCheckResponse.builder()
                .available(true)
                .message("성공")
                .build();
    }
    // 사용 가능할 경우 객체생성 메서드
    public static DuplicateCheckResponse unavailable(String message){
        return DuplicateCheckResponse.builder()
                .available(false)
                .message(message)
                .build();
    }
}
