package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.Talent.dto.SingleUserTalentRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryRepository {



    // 메인 카테고리 조회.
    List<String> getCategoriesMain();


    // 메인 카테고리를 통한 소분류카테고리 조회
    List<String> getSubCategories(String mainCategoryName);

    // 지리적 권역 조회
    List<String> getRegionName(String regionGroupName);

    // 시 별 조회
    List<String> getProvinceName(String regionGroupName);

    // 구별 조회
    List<String> getDistrictName(String provinceName);


    //단일 유저 카테고리 조회
    List<SingleUserTalentRequest> getUserCategory(SingleUserTalentRequest singleUserTalentRequest);
}
