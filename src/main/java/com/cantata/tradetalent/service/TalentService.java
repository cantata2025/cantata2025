package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.Talent.dto.TalentRequest;
import com.cantata.tradetalent.domain.Talent.entity.UserTalent;
import com.cantata.tradetalent.repository.TalentCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TalentService {

    private final TalentCategoryRepository talentCategoryRepository;

    // 유저 카테고리 등록
    public String createTalent(TalentRequest talentRequest ,boolean isGive) {
        int type = isGive ? 1: 2;
        UserTalent entry = TalentRequest.toEntry(type, talentRequest);
        talentCategoryRepository.createTalent(talentRequest);
        return entry.toString();

    }
}

