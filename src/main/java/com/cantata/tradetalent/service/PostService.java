package com.cantata.tradetalent.service;


import com.cantata.tradetalent.domain.Post.dto.request.OptionalSearchPostRequest;
import com.cantata.tradetalent.domain.Post.dto.request.UpdatedContentRequest;
import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.domain.Post.dto.response.SearchResponse;
import com.cantata.tradetalent.domain.Post.entity.Post;
import com.cantata.tradetalent.exception.ErrorCode;
import com.cantata.tradetalent.exception.PostException;
import com.cantata.tradetalent.exception.UserException;
import com.cantata.tradetalent.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    // 게시글 생성
    public int insertPost(
           UploadPostRequest uploadPostRequest
    ){
        postRepository.savePost(uploadPostRequest);

        return uploadPostRequest.getId();
    }


    // 게시글 조회
    public List<SearchResponse> findPostByKeyword(OptionalSearchPostRequest optionalSearchPostRequest){

        log.info("post service optional search : {}",optionalSearchPostRequest);

        return postRepository.findByKeyword(optionalSearchPostRequest);
    }

    // 게시글 단일조회
    public SearchResponse findPostById(int id){

        log.info("post service findPostById : {}",id);

        return postRepository.findPostById(id)
                .orElseThrow(
                        () -> new PostException(ErrorCode.POST_NOT_FOUND)
                );
    }

    // 게시글 내용 수정
    public SearchResponse updatePostContent(UpdatedContentRequest updatedContentRequest){

        // 게시글 정보 업데이트
        SearchResponse foundPost = findPostById(updatedContentRequest.getId());
        postRepository.updatePost(updatedContentRequest);

        return findPostById(updatedContentRequest.getId());
    }

    // 게시글 조회수 증가
    public SearchResponse increaseViewCount(int id){

        // 게시물 조회수 +1 업데이트
        SearchResponse foundPost = findPostById(id);
        postRepository.updateViewCount(id);

        return findPostById(id);
    }

    // 게시글 삭제
    public SearchResponse removePost(int id){

        // 게시글 여부 검사
        SearchResponse deletedPost = findPostById(id);
        postRepository.deletePostById(id);

        return deletedPost;
    }
}
