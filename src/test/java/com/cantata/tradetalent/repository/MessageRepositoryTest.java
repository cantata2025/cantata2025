package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.test.entity.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    @DisplayName("dd")
    void dd() {
        //given

        //when
        messageRepository.sendMessage(Message.builder()
                        .senderId(2)
                        .receiverId(3)
                        .content("dfasdfsa")
                .build());
        //then
    }

}