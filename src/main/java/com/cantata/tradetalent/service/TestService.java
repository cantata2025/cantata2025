package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.test.entity.TestGet;
import com.cantata.tradetalent.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<TestGet> getAPi(){
        List<TestGet> testGetList = testRepository.getTest();
        return testGetList;
    }
}
