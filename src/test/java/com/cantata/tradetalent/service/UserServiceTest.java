package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.User.entity.User;
import com.cantata.tradetalent.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void user(){
        User member = User.builder()
                .email("aaa@aaa.com")
                .password("sssss")
                .name("aaa")
                .build();

        userRepository.saveUser(member);
    }
}