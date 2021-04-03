package com.itlab.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestDao {
    String selectTest();

    int insertStressTest(String test);
}
