package com.cantata.tradetalent.repository;

import com.cantata.tradetalent.domain.test.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageRepository {

    //메시지 보내는 메서드
    void sendMessage(Message message);

    // 메시지 수신
    int updateMessageReceive(@Param("id") Integer id, @Param("receiverId") Integer receiverId);


    // 메시지 삭제
    int deleteMessage(Long id);
}
