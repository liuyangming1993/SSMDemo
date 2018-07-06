package com.demo.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(value = SpringJUnit4ClassRunner.class) // 测试运行器
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" }) // 加载配置文件
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public class Junit4Test {

}
