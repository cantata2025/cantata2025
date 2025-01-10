package com.cantata.tradetalent.controller.rest;


import com.cantata.tradetalent.domain.test.dto.request.MessageDto;
import com.cantata.tradetalent.domain.test.dto.request.MessageReadDto;
import com.cantata.tradetalent.domain.test.entity.Message;
import com.cantata.tradetalent.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/cantata/user")
@Slf4j
@RequiredArgsConstructor

public class MessageApiContoller {
    private final MessageService messageService;


    // 메시지 발신
    @PostMapping()
    public ResponseEntity<?> createMessage(@RequestBody @Valid MessageDto messageDto) {
        log.info("Create message: {}", messageDto);
        messageService.sendMessage(messageDto);
        return ResponseEntity.ok().body("전송이 완료되었습니다");
    }

    // 메시지 수신

    @PutMapping("/{id}")
    public ResponseEntity<?> readMessage(
            @PathVariable int id,
            @RequestBody @Valid MessageReadDto messageReadDto) {

        messageReadDto.setMessageId(id);  // PathVariable로 전달된 ID를 DTO에 설정
        messageService.readMessage(messageReadDto);
        return ResponseEntity.ok("메시지 상태가 업데이트되었습니다.");
    }

    //메시지 삭제
    @PutMapping("/remove/{id}")
    public ResponseEntity<?> removeMessage(
            @PathVariable Long id,
            @Valid Message message){

        message.setId(id);
        messageService.remove(id);
        return ResponseEntity.ok().body("삭제가 완료되었습니다.");
    }
}
