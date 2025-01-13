package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.test.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    List<Category> getCategories();


    // 메인 카테고리 조회
    List<String> getCategoriesMain();


    // 메인 카테고리를 통한 소분류카테고리 조회
    List<String> getSubCategories(String mainCategoryName);
}
