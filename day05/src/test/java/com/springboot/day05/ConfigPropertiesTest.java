package com.springboot.day05;

import com.springboot.day05.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigPropertiesTest {

  @Autowired
  private RedisConfig redisConfig;

  @Test
  public void configTest(){
    System.out.println(redisConfig.getName());
    System.out.println(redisConfig.getSize());
    System.out.println(redisConfig.getTimeout());
  }
}
