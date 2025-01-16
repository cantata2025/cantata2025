package com.cantata.tradetalent.domain.Talent.entity;

import lombok.*;
import org.apache.ibatis.annotations.Property;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTalent {

    private String userEmail;  //회원 이메일
    private int type; // 1-give 2-take
    private String subGiveTalentName; // 줄 수 있는 기능
    private String subTakeTalentName; // 받고 싶은 기능

}
