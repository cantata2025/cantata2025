package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.repository.PostRepository;
import com.cantata.tradetalent.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/cantata/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> uploadPost(
            @RequestBody UploadPostRequest uploadPostRequest
            ){

        log.info("upload post : {}",uploadPostRequest);
        postService.insertPost(uploadPostRequest);
        return ResponseEntity.ok().body("성공");
    }
}
