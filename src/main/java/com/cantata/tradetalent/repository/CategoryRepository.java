package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.test.entity.CategoryTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    List<CategoryTest> getCategories();

}
