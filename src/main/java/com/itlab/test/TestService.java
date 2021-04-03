package com.itlab.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public String getTest() {
        return testDao.selectTest();
    }

    public int createStressTest(String test) {
        return testDao.insertStressTest(test);
    }
}
