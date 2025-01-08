package com.cantata.tradetalent.controller.rest;


import com.cantata.tradetalent.domain.test.entity.TestGet;
import com.cantata.tradetalent.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cantata/test")
@RequiredArgsConstructor
public class ApiTestController {

    private final TestService testService;

    @GetMapping
    public ResponseEntity<?> getUser(){
        List<TestGet> testGetList = testService.getAPi();

        return ResponseEntity.ok()
                .body(testGetList);
    }
}
