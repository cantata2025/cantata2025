package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.test.entity.Category;
import com.cantata.tradetalent.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cantata/categories")
@RequiredArgsConstructor
public class CategoryApiController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        List<Category> response = categoryService.getAllCategories();
        return ResponseEntity.ok().body(response);
    }


    //메인 카테고리 조회
    @GetMapping("/main")
    public ResponseEntity<?> getMainCategories() {
        List<String> response = categoryService.getMainCategories();
        return ResponseEntity.ok().body(response);
    }


    // 메인 카테고리 내의 소분류 조회
    @GetMapping("/{mainCategoryName}")
    public ResponseEntity<?> getMainCategory(@PathVariable String mainCategoryName){
    List<String> sub = categoryService.getSubCategories(mainCategoryName);
    return ResponseEntity.ok().body(sub);
    }
}
