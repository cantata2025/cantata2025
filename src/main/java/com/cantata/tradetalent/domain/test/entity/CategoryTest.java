package com.cantata.tradetalent.domain.test.entity;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CategoryTest {
    private int id;
    private int mainCategory;
    private String mainCategoryName;
    private int subCategory;
    private String subCategoryName;

}
