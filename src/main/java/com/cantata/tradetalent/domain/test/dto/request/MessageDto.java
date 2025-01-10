package com.cantata.tradetalent.domain.test.dto.request;

import com.cantata.tradetalent.domain.test.entity.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {


    private int senderId; //발신인 ID
    private int receiverId; //수신인 ID
    @Size(min = 15, max = 1200, message = "최소 15자에서 최대 1200내외로 작성해주세요")
    private String content; // 쪽지내용


    public Message toMessage() {
        return Message.builder()
                .senderId(this.senderId)
                .receiverId(this.receiverId)
                .content(this.content)
                .createdAt(LocalDateTime.now())
                .receivedAt(LocalDateTime.now())
                .isRead(true)
                .isDeleted(false)
                .build();
    }
}
