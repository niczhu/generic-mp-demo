package com.md.mp.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MybatisPlusMetaHandler
 *
 * @author zhuhaipeng6 in 2020/5/9 18:18
 * @version 1.0
 */
@Component
public class MybatisPlusMetaHandler implements MetaObjectHandler {

    private static final String MODIFIED_TIME = "modifiedTime";
    private static final String MODIFIED_BY = "modifiedBy";
    private static final String CREATED_TIME = "createdTime";
    private static final String CREATED_BY = "createdBy";
    private static final String ID = "id";

    /**
     * 新增数据执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("===> mp handler insert fill===>");
        this.setFieldValByName(CREATED_TIME, new Date(), metaObject);
        this.setFieldValByName(MODIFIED_TIME, new Date(), metaObject);
        if (metaObject.getValue(CREATED_BY) == null || StringUtils.isBlank(metaObject.getValue(CREATED_BY).toString())) {
            this.setFieldValByName(CREATED_BY, getUserName(), metaObject);
        }
        this.setFieldValByName(MODIFIED_BY, getUserName(), metaObject);
    }

    /**
     * 更新数据执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("===> mp handler update fill===>");
        this.setFieldValByName(MODIFIED_TIME, new Date(), metaObject);
        this.setFieldValByName(MODIFIED_BY, getUserName(), metaObject);
    }

    public String getUserName() {
        return "system";
    }

    /**
     * mybatis-plus SQL执行效率插件【开发和测试开启】
     */
//    @Bean
//    @Profile({"dev","test"})
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
//        performanceInterceptor.setMaxTime(1000);
//        /*<!--SQL是否格式化 默认false-->*/
//        performanceInterceptor.setFormat(false);
//        return performanceInterceptor;
//    }


}
