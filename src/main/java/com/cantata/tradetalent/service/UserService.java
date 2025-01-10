package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.domain.User.dto.response.DuplicateCheckResponse;
import com.cantata.tradetalent.domain.User.entity.User;
import com.cantata.tradetalent.exception.ErrorCode;
import com.cantata.tradetalent.exception.UserException;
import com.cantata.tradetalent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //패스워드 암호화
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequest signUpRequest){
        // 비밀번호 암호화하기
        // 숩수 비밀번호를 꺼내서 암호화
        String rawPassword = signUpRequest.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        //회원정보를 데이터베이스에 저장
        User newUser = signUpRequest.toEntity();

        //암호화된 pw로 교체
        newUser.setPassword(encodedPassword);

        userRepository.saveUser(newUser);
    }

    public DuplicateCheckResponse checkDuplicate(String type, String value) {
        log.info("------------------"+type+"--------"+value);
        switch (type) {
            case "email":
                // 중복된 경우를 클라이언트에게 알려야함
                User user1 = userRepository.findByEmail(value)
                        .get();
                log.info("uuuuuuuu : {}",user1);
                return userRepository.findByEmail(value)
                        .map(user -> DuplicateCheckResponse.unavailable("이미 사용중인 이메일입니다.")) // null이 아닌 경우
                        .orElse(DuplicateCheckResponse.available());// null인 경우
            case "name":
                return userRepository.findByName(value)
                        .map(user -> DuplicateCheckResponse.unavailable("이미 사용중인 이름입니다.")) // null이 아닌 경우
                        .orElse(DuplicateCheckResponse.available());// null인 경우;
            default:
                throw new UserException(ErrorCode.INVALID_SIGNUP_DATA);

        }
    }
}
