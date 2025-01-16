package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.Category.dto.request.RegionCategoryDto;
import com.cantata.tradetalent.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cantata/categories")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;



    //메인 카테고리 조회 ex)음악
    @GetMapping("/main")
    public ResponseEntity<?> getMainCategories() {
        List<String> response = categoryService.getMainCategories();
        return ResponseEntity.ok().body(response);
    }


    // 메인 카테고리 내의 소분류 조회 ex) 피아노,재즈, 기타, 베이스
    @GetMapping("/main/{mainCategoryName}")
    public ResponseEntity<?> getMainCategory(@PathVariable String mainCategoryName){
    List<String> sub = categoryService.getSubCategories(mainCategoryName);
    return ResponseEntity.ok().body(sub);
    }

    // 그룹 지역 이름 조회
    @GetMapping("/region")
    public ResponseEntity<?> getMainRegion(
            String regionGroupName
    ){
        List<String> group = categoryService.getRegionCategories(regionGroupName);
        return ResponseEntity.ok().body(group);
    }

    // 수도권, 구별 조회
    @GetMapping("/region-option")
    public ResponseEntity<?> handleRequest(@RequestBody RegionCategoryDto request) {
        Map<String, Object> response = categoryService.findRegionOrProvince(request);
        return ResponseEntity.ok(response);



}

}
