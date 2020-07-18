package com.md.mp.config.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RdisProperties
 *
 * @author zhuhaipeng6 in 2020/7/13 16:59
 * @version 1.0
 **/

@Setter
@Getter
@ConfigurationProperties(prefix = "redis")
public class RedisConfigProperties {

    private String hostName;

    private String password;

    private int port;

    private int timeout = 6000;

}
