package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.test.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageRepository {
    //메시지 보내는 메서드
    void sendMessage(Message message);
}
