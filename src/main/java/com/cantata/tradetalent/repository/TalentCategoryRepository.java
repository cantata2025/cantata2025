package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.Talent.dto.TalentRequest;
import com.cantata.tradetalent.domain.Talent.entity.UserTalent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TalentCategoryRepository {

    // 유저 카테고리 등록
    void createTalent(TalentRequest talentRequest);
}

