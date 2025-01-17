package com.cantata.tradetalent.domain.Talent.entity;

import lombok.*;
import org.apache.ibatis.annotations.Property;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTalent {

    private Long id;
    private Long userId;  //회원 이메일
    private int type; // 1-give 2-take
    private int talentId; // 줄 수 있는 기능
    private LocalDateTime createdAt;

}
