package com.cantata.tradetalent.domain.Talent.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTalentRequest {
    private String subCategoryName;
    private String email;
}
