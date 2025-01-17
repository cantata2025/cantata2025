package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.Talent.dto.TalentRequest;
import com.cantata.tradetalent.domain.Talent.dto.UpdateTalentRequest;
import com.cantata.tradetalent.domain.Talent.entity.UserTalent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TalentCategoryRepository {

    // 유저 카테고리 등록
    void createTalent(
            @Param("email") String email
            ,@Param("type") int type
            ,@Param("talentName") String talentName);

    // 유저 카테고리 변경
    void updateTalent(UpdateTalentRequest updateTalentRequest);
}

