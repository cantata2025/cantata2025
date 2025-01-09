package com.cantata.tradetalent.service;


import com.cantata.tradetalent.domain.test.dto.MessageDto;
import com.cantata.tradetalent.domain.test.entity.Message;
import com.cantata.tradetalent.repository.MessageRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MessageService {
    private final MessageRepository messageRepository;

    public String sendMessage(MessageDto messageDto) {
        log.debug("sendMessage: {}", messageDto);
        Message message = messageDto.toMessage();

        //posts테이블에 insert
        messageRepository.sendMessage(message);
        return "";








    }
}
