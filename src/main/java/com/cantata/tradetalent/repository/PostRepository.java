package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.Post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    // 게시물 생성
    public void savePost();

    // 게시물 수정
    public Post updatePost();

    // 게시물 조회
    public List<Post> findAllPost();

    // 게시물 삭제
    public void deletePost();

    // 게시물 조회수
    public void increaseViewCount();
}
