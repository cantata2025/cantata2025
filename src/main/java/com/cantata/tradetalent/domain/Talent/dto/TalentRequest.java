package com.cantata.tradetalent.domain.Talent.dto;

import com.cantata.tradetalent.domain.Talent.entity.UserTalent;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TalentRequest {
    private String email;
    private String give;
    private String take;

    public static UserTalent toEntry(int type, TalentRequest talentRequest){
        return UserTalent.builder()
                .userEmail(talentRequest.getEmail())
                .type(type)
                .subTakeTalentName(talentRequest.getTake())
                .subGiveTalentName(talentRequest.getGive())
                .build();
    }
}
