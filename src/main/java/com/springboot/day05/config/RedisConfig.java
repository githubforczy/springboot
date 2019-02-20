package com.springboot.day05.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:./config/redis-config.properties")
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
  private String name;
  private String size;
  private String timeout;
}
