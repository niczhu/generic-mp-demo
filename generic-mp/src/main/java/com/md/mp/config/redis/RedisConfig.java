package com.md.mp.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * RedisConfig
 *
 * @author zhuhaipeng6 in 2020/7/13 16:51
 * @version 1.0
 **/
@Configuration
@EnableConfigurationProperties({RedisConfigProperties.class})
public class RedisConfig {

    @Autowired
    private RedisConfigProperties redisConfigProperties;

//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(8);
//        jedisPoolConfig.setMaxTotal(8);
//        jedisPoolConfig.setMaxWaitMillis(6000);
//        jedisPoolConfig.setTestOnBorrow(true);
//        return jedisPoolConfig;
//    }
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName(redisConfigProperties.getHostName());
//        jedisConnectionFactory.setPort(redisConfigProperties.getPort());
//        jedisConnectionFactory.setPassword(redisConfigProperties.getPassword());
//        jedisConnectionFactory.setTimeout(redisConfigProperties.getTimeout());
//        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
//        return jedisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        redisTemplate.setEnableTransactionSupport(true);
//
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//
//        return redisTemplate;
//    }

//    @Bean
//    public RedisCacheManager redisCacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
////        RedisCacheManager redisCacheManager = RedisCacheManager.create(jedisConnectionFactory());
//
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
//        redisCacheManager.setDefaultExpiration(300000);
//        redisCacheManager.setTransactionAware(true);
//        List<String> list = new ArrayList<>();
//        list.add("redisCache");
//
//        redisCacheManager.setCacheNames(list);
//
//        return redisCacheManager;
//    }


}
