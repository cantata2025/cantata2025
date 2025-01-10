package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.test.dto.request.MessageDto;
import com.cantata.tradetalent.domain.test.dto.request.MessageReadDto;
import com.cantata.tradetalent.domain.test.entity.Message;
import com.cantata.tradetalent.repository.MessageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MessageService {
    private final MessageRepository messageRepository;


    // 메시지 발신
    public String sendMessage(@Valid MessageDto messageDto) {
        log.debug("sendMessage: {}", messageDto);
        Message message = messageDto.toMessage();

        messageRepository.sendMessage(message);
        return "메시지가 성공적으로 발송되었습니다.";
    }

    // 메시지 수신

    public String readMessage(@Valid MessageReadDto messageReadDto) {
        // DTO에서 엔터티로 변환
        Message message = messageReadDto.toRead();

        log.debug("Converted Message: {}", message);

        // 메시지 읽음 상태 업데이트
        messageRepository.updateMessageRead(message);

        return "";
    }

    //메시지 삭제
    public void remove(Long id){
        boolean removed = messageRepository.deleteMessage(id);
        if (!removed) {
            throw new IllegalStateException("해당 id는 존재하지 않습니다. = " + id);
        }
    }


}
