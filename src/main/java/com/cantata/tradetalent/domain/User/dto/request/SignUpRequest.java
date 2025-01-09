package com.cantata.tradetalent.domain.User.dto.request;

import com.cantata.tradetalent.domain.User.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class SignUpRequest {

    private String email;   // 이메일 (id) 고유값
    private String password; // 비밀번호
    private String name;  // 닉네임 고유값

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }
}
