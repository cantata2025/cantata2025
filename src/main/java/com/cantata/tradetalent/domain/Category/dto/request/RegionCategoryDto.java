package com.cantata.tradetalent.domain.Category.dto.request;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor


public class RegionCategoryDto {
    private String regionCategory;
    private String provinceName;
    private String option;


}
