package com.cantata.tradetalent.domain.Talent.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

public class SingleUserTalentRequest {
    private int type;
    private String mainCategoryName;
    private String subCategoryName;
}
