package com.cantata.tradetalent.service;



import com.cantata.tradetalent.domain.Category.dto.request.RegionCategoryDto;
import com.cantata.tradetalent.domain.Talent.dto.SingleUserTalentRequest;
import com.cantata.tradetalent.repository.CategoryRepository;
import com.cantata.tradetalent.repository.TalentCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final TalentCategoryRepository talentCategoryRepository;


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
    // 시별 도별 조회처리


    public Map<String , Object> findRegionOrProvince(RegionCategoryDto regionCategoryDto) {
        Map<String, Object> response = new HashMap<>();

        if ("region".equals(regionCategoryDto.getOption())) {
            // regionCategory 처리
            List<String> provinceNames = categoryRepository.getProvinceName(regionCategoryDto.getRegionCategory());
            response.put("option", "region");
            response.put("regionCategory", regionCategoryDto.getRegionCategory());
            response.put("provinces", provinceNames);

        } else if ("province".equals(regionCategoryDto.getOption())) {
            // provinceName 처리
            List<String> districtNames = categoryRepository.getDistrictName(regionCategoryDto.getProvinceName());
            response.put("option", "province");
            response.put("provinceName", regionCategoryDto.getProvinceName());
            response.put("districts", districtNames);

        } else {
            throw new IllegalArgumentException("Invalid option provided");
        }

        return response;

    }



    // 유저 카테고리 단일 조회
    public List<SingleUserTalentRequest> getSingleUserTalents(String email) {

        List<SingleUserTalentRequest> userCategory = categoryRepository.getUserCategory(email);
        return userCategory;
    }
    }



