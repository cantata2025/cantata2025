package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.Message.entity.TestGet;
import com.cantata.tradetalent.repository.TestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestServiceTestGet {

    private static final Logger log = LoggerFactory.getLogger(TestServiceTestGet.class);
    @Autowired
    TestRepository testRepository;

    @BeforeEach
    void setUp() {
        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>> Test Start <<<<<<<<<<<<<<<<<<<<");
    }

    @Test
    void getUserTest() {
        List<TestGet> testList = testRepository.getTest();

        for (TestGet testGet : testList) {
            log.info(String.valueOf(testGet));
        }
    }
    @AfterEach
    void tearDown() {
        System.out.println(">>>>>>>>>>>>>>>>>>>> Test End <<<<<<<<<<<<<<<<<<<<\n\n");
        // 각 테스트 실행 후 정리 작업
    }
}