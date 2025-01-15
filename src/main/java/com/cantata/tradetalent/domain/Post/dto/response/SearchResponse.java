package com.cantata.tradetalent.domain.Post.dto.response;

import com.cantata.tradetalent.domain.Post.entity.Post;

import java.time.LocalDateTime;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class SearchResponse {
    private Long id;                      // pk
    private String regionName;                // 지역 (필수값)
    private String provinceName;                // 지역 (필수값)
    private String districtName;                // 지역 (필수값)
    private String categoryNameGive;           // 줄 수 있는 카테고리 번호 (필수값)
    private String categoryNameTake;           // 받고 싶은 카테고리 번호 (필수값)
    private String content;               // 내용 (필수값)
    private String writer;                // 작성자 (필수값)
    private int viewCount;            // 조회수, 기본값 0
    private LocalDateTime createdAt;          // 게시글 등록일
}
