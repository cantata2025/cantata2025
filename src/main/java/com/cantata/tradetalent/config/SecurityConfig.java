package com.cantata.tradetalent.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity   // 커스텀 시큐리티 설정파일
@RequiredArgsConstructor
public class SecurityConfig {

    //시큐리티 필터체인 빈을 등록
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //커스텀 보안설정
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configure(http))
                // 세션인증을 비활성화
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // 인가 설정
                .authorizeHttpRequests(auth ->
                        auth
                                // '/api/auth' 로 시작하는 요청은 인증을 필요로 하지 않음
                                .requestMatchers("/api/cantata/auth/**").permitAll()
                                // '/api' 로 시작하는 요청은 모두 인증은 필수로 처리
                                .requestMatchers("/api/cantata/**").authenticated()
                                // 기타 (jsp,js, css, image....) 는 모두 허용
                                .anyRequest().permitAll()
                )
                // 시큐리티 기본 인증인가차단의 상태코드는 403
                // 403은 인가차단이기에 인증차단을 401로 변경
                .exceptionHandling(ex->
                        ex.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                        )
        ;
        return http.build();
    }

}
