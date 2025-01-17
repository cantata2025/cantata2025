package com.cantata.tradetalent.domain.Talent.dto;

import com.cantata.tradetalent.domain.Talent.entity.UserTalent;
import com.cantata.tradetalent.domain.User.entity.User;
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

}
