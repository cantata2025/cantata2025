package com.cantata.tradetalent.controller.rest;


import com.cantata.tradetalent.domain.Message.dto.request.MessageDto;
import com.cantata.tradetalent.domain.Message.entity.Message;
import com.cantata.tradetalent.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cantata/message")
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

    @PutMapping("/receive")
    public ResponseEntity<?> receiveMessage(@RequestBody Map<String, Object> request) {
        Integer id = (Integer) request.get("id");
        Integer receiverId = (Integer) request.get("receiverId");

        if (id == null || receiverId == null) {
            return ResponseEntity.badRequest().body("id와 receiverId는 필수입니다.");
        }

        // 서비스 호출
        messageService.receiveMessage(id, receiverId);

        return ResponseEntity.ok("메시지가 수신 처리되었습니다.");
    }

    //메시지 삭제(삭제시 isDeleted = 1)
    @PutMapping("/remove/{id}")
    public ResponseEntity<?> removeMessage(
            @PathVariable Long id,
            @Valid Message message){

        message.setId(id);
        messageService.remove(id);
        return ResponseEntity.ok().body("삭제가 완료되었습니다.");
    }
}
