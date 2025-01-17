package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.Talent.dto.TalentRequest;
import com.cantata.tradetalent.domain.Talent.dto.UpdateTalentRequest;
import com.cantata.tradetalent.repository.TalentCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TalentService {

    private final TalentCategoryRepository talentCategoryRepository;

    // 유저 카테고리 등록
    public String createTalent(TalentRequest talentRequest) {
        int type;
        String talent;
        String email = talentRequest.getEmail();

        // type과 talent 결정
        if (!talentRequest.getGive().isEmpty()) {
            type = 1; // 주는 재능
            talent = talentRequest.getGive();
            // Repository 호출
            talentCategoryRepository.createTalent(email,type,talent);
        }

        if(!talentRequest.getTake().isEmpty()){
            type = 2; // 받는 재능
            talent =  talentRequest.getTake();
            // Repository 호출
            talentCategoryRepository.createTalent(email,type,talent);
        }

        return "추가가 완료되었습니다.";
    }

}


