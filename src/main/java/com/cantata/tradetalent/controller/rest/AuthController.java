package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.User.dto.request.LoginRequest;
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

    // 로그인 검증 api
    // GET 방식 - ? 사용 => 보완상 좋지 않음
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody @Valid LoginRequest loginRequest
    ){
        log.info("request for authenticate user : {}",loginRequest);
        Map<String,Object> responseMap = userService.authenticate((loginRequest));
        return ResponseEntity.ok().body(responseMap);
    }


}
