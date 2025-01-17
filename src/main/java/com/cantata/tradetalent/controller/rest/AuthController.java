package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.Talent.dto.TalentRequest;
import com.cantata.tradetalent.domain.User.dto.request.LoginRequest;
import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.domain.User.dto.response.DuplicateCheckResponse;
import com.cantata.tradetalent.service.TalentService;
import com.cantata.tradetalent.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cantata/auth")
@Slf4j
public class AuthController {

    private final UserService userService;
    private final TalentService talentService;

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
            , HttpServletResponse response
    ){
        log.info("request for authenticate user : {}",loginRequest);
        Map<String,Object> responseMap = userService.authenticate((loginRequest));

        Cookie cookie = new Cookie("accessToken", (String) responseMap.get("accessToken"));
        // 쿠키의 수명, 사용경로, 보안 등을 설정
        cookie.setMaxAge(60 * 60); // 단위: 초
        cookie.setPath("/");
        cookie.setHttpOnly(true); // 보안설정 - 자바스크립트로는 쿠키에 접근 불가
        // 쿠키를 클라이언트에 전송
        response.addCookie(cookie);

        return ResponseEntity.ok().body(responseMap);
    }

    // 로그아웃 처리 API
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        // 쿠키 무효화
        Cookie cookie = new Cookie("accessToken", null);
        // 쿠키의 수명, 사용경로, 보안 등을 설정
        cookie.setMaxAge(0); // 단위: 초
        cookie.setPath("/");
        cookie.setHttpOnly(true); // 보안설정 - 자바스크립트로는 쿠키에 접근 불가
        // 쿠키를 클라이언트에 전송
        response.addCookie(cookie);
        return ResponseEntity.ok().body(Map.of(
                "message", "로그아웃이 처리되었습니다."
        ));
    }
    // 회원 카테고리 생성
    @PostMapping("/accept")
    public ResponseEntity<?> createUserTalent(
            @RequestBody TalentRequest talentRequest
            ){

        log.info("talentRequestaaaa : {}",talentRequest);
        String talent = talentService.createTalent(talentRequest);


        return ResponseEntity.ok().body(Map.of(
                "message", talent
        ));

    }


}
