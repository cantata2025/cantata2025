package com.cantata.tradetalent.domain.test.dto.request;

import com.cantata.tradetalent.domain.test.entity.Message;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MessageReadDto {
    private int messageId; // 메시지 id
    private boolean isRead; // 읽었는지 확인
    private LocalDateTime receivedAt;  // 수신 시간



    public Message toRead(){
        return Message.builder()
                .senderId(this.messageId)
                .isRead(true)
                .receivedAt(this.receivedAt)
                .build();

    }
}
