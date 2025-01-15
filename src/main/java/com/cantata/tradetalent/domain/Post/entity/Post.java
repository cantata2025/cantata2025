package com.cantata.tradetalent.domain.Post.entity;


import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Post {
    private Long id;                      // pk
    private String region;                // 지역 (필수값)
    private String categoryIdGive;           // 줄 수 있는 카테고리 번호 (필수값)
    private String categoryIdTake;           // 받고 싶은 카테고리 번호 (필수값)
    private String content;               // 내용 (필수값)
    private String writer;                // 작성자 (필수값)
    private int viewCount;            // 조회수, 기본값 0
    private LocalDateTime createdAt;          // 게시글 등록일
    private LocalDateTime updatedAt;          // 게시글 최종 수정일
    private LocalDateTime deletedAt;          // 게시글 삭제일
}
