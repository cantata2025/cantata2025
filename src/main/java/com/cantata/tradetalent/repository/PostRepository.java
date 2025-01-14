package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.Post.dto.request.OptionalSearchPostRequest;
import com.cantata.tradetalent.domain.Post.dto.request.UpdatedContentRequest;
import com.cantata.tradetalent.domain.Post.dto.request.UploadPostRequest;
import com.cantata.tradetalent.domain.Post.dto.response.SearchResponse;
import com.cantata.tradetalent.domain.Post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    // 게시물 생성
    public void savePost(UploadPostRequest uploadPostRequest);

    // 게시물 수정
    public Post updatePost(int id, String context);

    // 게시물 조회
    public List<Post> findAllPost();

    // 게시물 키워드 조회
    public List<SearchResponse> findByKeyword(OptionalSearchPostRequest optionalSearchPostRequest);

    // 게시글 단일 조회 (id)
    public SearchResponse findPostById(int id);

    // 게시글 수정
    public void updatePost (UpdatedContentRequest updatedContentRequest);

    // 게시물 삭제
    public void deletePost(int id);

    // 게시물 조회수
    public void updateViewCount(int id);
}
