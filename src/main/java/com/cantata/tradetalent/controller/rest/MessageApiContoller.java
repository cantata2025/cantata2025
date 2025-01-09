package com.cantata.tradetalent.controller.rest;


import com.cantata.tradetalent.domain.test.dto.MessageDto;
import com.cantata.tradetalent.domain.test.entity.Message;
import com.cantata.tradetalent.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cantata/user")
@Slf4j
@RequiredArgsConstructor

public class MessageApiContoller {
    private final MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<?> createMessage(@RequestBody @Valid MessageDto messageDto) {
        log.info("Create message: {}", messageDto);
        messageService.sendMessage(messageDto);
        return ResponseEntity.ok().build();
    }
}
