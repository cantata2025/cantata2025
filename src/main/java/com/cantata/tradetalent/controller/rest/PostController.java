package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.repository.PostRepository;
import com.cantata.tradetalent.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/cantata/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> uploadPost(
            @RequestBody UploadPostRequest uploadPostRequest
            // username => email
            ,@AuthenticationPrincipal String username
            ){

        log.info("upload post : {}",uploadPostRequest);
        log.info("token username : {}",username);

        uploadPostRequest.setEmail(username);

        int postId = postService.insertPost(uploadPostRequest);

        // 응답 메시지 JSON 생성 { "id": 23, "message": "save success" }
        Map<String, Object> response = Map.of(
                "postId", postId
                , "message", "save success"
        );

        return ResponseEntity.ok().body(response);
    }
}
