package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.test.entity.CategoryTest;
import com.cantata.tradetalent.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryTest> getAllCategories() {
        List<CategoryTest> categories = categoryRepository.getCategories()
                .stream()
                .sorted(Comparator.comparing(CategoryTest::getMainCategoryName)
                .reversed()).collect(Collectors.toList());
        return categories;
    }
}
