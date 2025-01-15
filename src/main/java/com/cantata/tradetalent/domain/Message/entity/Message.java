package com.cantata.tradetalent.domain.Message.entity;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Message {
    private Long id; //쪽지 고유 ID
    private int senderId; // 발신인 ID
    private int receiverId; //수신인 ID
    private String content; // 쪽지내용
    private LocalDateTime createdAt; //작성시간
    private LocalDateTime receivedAt;
    private boolean isRead; // 읽음 여부
    private boolean isDeleted; //삭제 여부
}
