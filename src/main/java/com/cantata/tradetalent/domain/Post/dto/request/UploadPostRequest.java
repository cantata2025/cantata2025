package com.cantata.tradetalent.domain.Post.dto.request;

import com.cantata.tradetalent.domain.Post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UploadPostRequest {

    private int id;  // 자동 생성된 id를 저장할 필드

    @JsonProperty("email")
    private String email;

    @JsonProperty("area1")
    private String region;          // 경상권

    @JsonProperty("area2")
    private String province;  // 부산광역시

    @JsonProperty("area3")
    private String district;  // 남구

    @JsonProperty("giveCategory")
    private String categoryGive;   // 영어

    @JsonProperty("receiveCategory")
    private String categoryTake;   // 태권도

    @JsonProperty("contentText")
    private String content;
}

