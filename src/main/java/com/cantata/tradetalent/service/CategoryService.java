package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.test.entity.Category;
import com.cantata.tradetalent.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

//    카테고리 전체 조회
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.getCategories();
        return categories;
    }

    // 메인 카테고리 조회
    public List<String> getMainCategories() {
        List<String> categoryDtos = categoryRepository.getCategoriesMain();
        return categoryDtos;
    }

    //서브 카테고리 조회
    public List<String> getSubCategories(String mainCategoryName) {
        List<String> categoryDtos = categoryRepository.getSubCategories(mainCategoryName);
        return categoryDtos;
    }


}
