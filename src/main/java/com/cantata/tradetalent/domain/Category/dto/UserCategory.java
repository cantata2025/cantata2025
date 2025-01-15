package com.cantata.tradetalent.domain.Category.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserCategory {
    private int id;
    private int mainCategory;
    private String mainCategoryName;
    private int subCategory;
    private String subCategoryName;

}
