package com.cantata.tradetalent.domain.Post.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class uploadPostRequest {

    @JsonProperty("email")
    String email;

    @JsonProperty("area1")
    String region;          // 경상권

    @JsonProperty("area2")
    String province;  // 부산광역시

    @JsonProperty("area3")
    String district;  // 남구

    @JsonProperty("giveCategory")
    String Category_give;   // 영어

    @JsonProperty("receiveCategory")
    String Category_take;   // 태권도

    @JsonProperty("contentText")
    String content;

    //const newLessonData = {
//        area1: area1,//광역
//        area2: area2,//시도
//        area3: area3,//시구군
//        giveCategory: giveCategory,
//        receiveCategory: receiveCategory,
//        contentText: contentText,
//    }

}
