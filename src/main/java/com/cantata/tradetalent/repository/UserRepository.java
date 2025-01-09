package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.User.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserRepository {
    void saveUser(User user);

    //중복체크용 조회 메서드
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);

    // 회원정보 조회
    User findUser(String name);

    // 회원정보 수정
    User updateUserInfo();

    // 회원정보 삭제
    void deleteUser(User user);
}
