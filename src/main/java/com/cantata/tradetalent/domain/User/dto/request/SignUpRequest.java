package com.cantata.tradetalent.domain.User.dto.request;

import com.cantata.tradetalent.domain.User.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class SignUpRequest {


    @NotBlank (message = "이메일을 입력해주세요.")
    private String email;   // 이메일 (id) 고유값

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "비밀번호는 8자 이상, 영문과 숫자 조합이어야 합니다")
    private String password; // 비밀번호

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;  // 닉네임 고유값

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }
}
