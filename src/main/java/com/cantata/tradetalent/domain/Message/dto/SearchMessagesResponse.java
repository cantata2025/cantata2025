package com.cantata.tradetalent.domain.Message.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@Builder
public class SearchMessagesResponse {
    private Long id;
    private String senderEmail;
    private String receiverEmail;
    private String content;
    private LocalDateTime createdAt;
    private boolean idRead;
}
