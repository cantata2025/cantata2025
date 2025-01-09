package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.User.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    void saveUser(User user);
}
