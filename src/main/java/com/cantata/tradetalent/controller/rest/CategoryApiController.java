package com.cantata.tradetalent.controller.rest;

import com.cantata.tradetalent.domain.Category.dto.UserCategory;
import com.cantata.tradetalent.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cantata/categories")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;



    //메인 카테고리 조회
    @GetMapping("/main")
    public ResponseEntity<?> getMainCategories() {
        List<String> response = categoryService.getMainCategories();
        return ResponseEntity.ok().body(response);
    }


    // 메인 카테고리 내의 소분류 조회
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

    // 시별 조회
    @GetMapping("/rg/{regionGroupName}")
    public ResponseEntity<?> getMainProvince(
            @PathVariable String regionGroupName
    ) {
        // 지역 데이터 조회
        List<String> province = categoryService.provinceName(regionGroupName);


        Map<String, Object> response = new HashMap<>();
        response.put("option", "region");
        response.put("regionGroupName", regionGroupName);
        response.put("provinces", province);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/pn/{provinceName}")
    public ResponseEntity<?> getDistrict(
            @PathVariable String provinceName
    ){
        List<String> districtName = categoryService.districtName(provinceName);

        Map<String, Object> response = new HashMap<>();
        response.put("option", provinceName);
        response.put("provinceName", districtName);
            return ResponseEntity.ok().body(response);
        }



}
