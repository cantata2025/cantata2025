package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cantata/auth")
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

}
