package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.domain.User.dto.response.DuplicateCheckResponse;
import com.cantata.tradetalent.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cantata/auth")
@Slf4j
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> createUser(
            @RequestBody @Valid SignUpRequest signUp
            ){
        userService.signUp(signUp);

        return ResponseEntity.ok()
                .body(Map.of("message" , "회원가입완료",
                "email",signUp.getEmail())
        );
    }

    // 중복확인을 검사하는 api
    @GetMapping("/user-duplicate")
    public ResponseEntity<?> checkDuplicate(
            @RequestParam String type,
            @RequestParam String value
    ){
        log.info("check duplicate type:{},value:{}",type,value);
        DuplicateCheckResponse responsedto = userService.checkDuplicate(type, value);
        log.info("responsedto : {}",responsedto);
        return ResponseEntity.ok().body(responsedto);
    }

}
