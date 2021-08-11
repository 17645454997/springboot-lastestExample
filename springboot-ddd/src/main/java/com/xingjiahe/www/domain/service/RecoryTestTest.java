package com.xingjiahe.www.domain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hsw
 * @Date 17:34 2018/7/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecoryTestTest {

    @Autowired
    private RecoryTest recoryTest;

    @Test
    public void retry() {
        recoryTest.retry();
    }

    @Test
    public void test() {
        recoryTest.test();
    }
}
