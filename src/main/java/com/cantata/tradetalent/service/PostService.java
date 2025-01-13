package com.cantata.tradetalent.service;


import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void insertPost(UploadPostRequest uploadPostRequest){

        postRepository.savePost(uploadPostRequest);

    }
}
