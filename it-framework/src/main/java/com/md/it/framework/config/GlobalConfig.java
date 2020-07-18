package com.md.it.framework.config;

import com.md.it.framework.constraint.service.ValidatorService;
import com.md.it.framework.constraint.service.ValidatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GloableConfig
 *
 * @author zhuhaipeng6 in 2020/4/11 19:49
 * @version 1.0
 **/
@Configuration
public class GlobalConfig {


    @Bean
    public ValidatorService validatorService() {
        return new ValidatorServiceImpl();
    }

//    @Bean
//    public AccountModelResolver accountModelResolver() {
//        return new AccountModelResolver();
//    }

//    @Bean
//    public UncaughtExceptionHandler uncaughtExpHandler() {
//        return new UncaughtExceptionHandler();
//    }


}
