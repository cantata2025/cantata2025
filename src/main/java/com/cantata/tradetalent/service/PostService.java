package com.cantata.tradetalent.service;


import com.cantata.tradetalent.domain.Post.dto.request.OptionalSearchPostRequest;
import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.domain.Post.entity.Post;
import com.cantata.tradetalent.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public int insertPost(
           UploadPostRequest uploadPostRequest
    ){
        postRepository.savePost(uploadPostRequest);

        return uploadPostRequest.getId();
    }

    public List<Post> findPostByKeyword(OptionalSearchPostRequest optionalSearchPostRequest){

        log.info("post service optional search : {}",optionalSearchPostRequest);
        return postRepository.findByKeyword(optionalSearchPostRequest);
    }
}
