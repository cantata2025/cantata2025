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
    String email;

    @JsonProperty("area1")
    String region;          // 경상권

    @JsonProperty("area2")
    String province;  // 부산광역시

    @JsonProperty("area3")
    String district;  // 남구

    @JsonProperty("giveCategory")
    String categoryGive;   // 영어

    @JsonProperty("receiveCategory")
    String categoryTake;   // 태권도

    @JsonProperty("contentText")
    String content;
}

