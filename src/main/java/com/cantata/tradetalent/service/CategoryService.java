package com.cantata.tradetalent.service;



import com.cantata.tradetalent.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;




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

    //지리적 권역 조회
    public List<String> getRegionCategories(String regionGroupName){
        List<String> regionDto = categoryRepository.getRegionName(regionGroupName);
        return regionDto;
    }
    // 시별 조회
    public List<String> provinceName(String regionGroupName) {
        List<String> provinceDto = categoryRepository.getProvinceName(regionGroupName);
        return provinceDto;
    }
    //도별 조회
    public List<String> districtName(String provinceName) {
        List<String> districtDto = categoryRepository.getDistrictName(provinceName);
        return districtDto;
    }


}
