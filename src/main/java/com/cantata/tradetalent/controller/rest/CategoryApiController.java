package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.test.entity.CategoryTest;
import com.cantata.tradetalent.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<CategoryTest> response = categoryService.getAllCategories();
        return ResponseEntity.ok().body(response);
    }
}
