package com.cantata.tradetalent.service;

import com.cantata.tradetalent.domain.User.dto.request.LoginRequest;
import com.cantata.tradetalent.domain.User.dto.request.SignUpRequest;
import com.cantata.tradetalent.domain.User.dto.response.DuplicateCheckResponse;
import com.cantata.tradetalent.domain.User.entity.User;
import com.cantata.tradetalent.exception.ErrorCode;
import com.cantata.tradetalent.exception.UserException;
import com.cantata.tradetalent.jwt.JwtTokenProvider;
import com.cantata.tradetalent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //패스워드 암호화
    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;


    public void signUp(SignUpRequest signUpRequest) {


        // rade condition 방지
        userRepository.findByEmail(signUpRequest.getEmail())
                .ifPresent(m -> {
                    throw new UserException(ErrorCode.DUPLICATE_EMAIL);
                });

        userRepository.findByName(signUpRequest.getName())
                .ifPresent(m -> {
                    throw new UserException(ErrorCode.DUPLICATE_USERNAME);
                });

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
        log.info("------------------" + type + "--------" + value);
        switch (type) {
            case "email":
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

    @Transactional(readOnly = true)
    public Map<String, Object> authenticate(LoginRequest loginRequest) {

        String username = loginRequest.getUsername();

        User foundUser = userRepository.findByEmail(username)
                .orElseGet(() -> userRepository.findByName(username)
                        .orElseThrow(() ->
                                new UserException(ErrorCode.MEMBER_NOT_FOUND)
                        ));

        // 사용자가 입력한 패스워드와 DB에 저장한 패스워드를 추출
        String inputPassword = loginRequest.getPassword();
        String storePassword = foundUser.getPassword();

        // 비번이 일지하지 않으면 예외 발생
        // 암호화된 비밀번호를 디코딩해서 비교해야함
        if (!passwordEncoder.matches(inputPassword, storePassword)) {
            throw new UserException(ErrorCode.INVALID_PASSWORD);
        }

        // 로그인 성공 (엑세스 토큰 포함)
        return Map.of(
                "message", "로그인에 성공했습니다.",
                "username", foundUser.getEmail(),
                "accessToken", jwtTokenProvider.createAccessToken(foundUser.getEmail())
        );
    }
}
