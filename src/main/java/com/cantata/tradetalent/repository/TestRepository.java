package com.cantata.tradetalent.repository;


import com.cantata.tradetalent.domain.Message.entity.TestGet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestRepository {

    List<TestGet> getTest();
}
