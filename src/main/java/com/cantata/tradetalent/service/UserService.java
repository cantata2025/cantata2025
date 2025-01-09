package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(SignUpRequest user){
        // 비밀번호 암호화하기

        userRepository.saveUser(user.toEntity());
    }
}
