package com.md.it.framework.constraint.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/**
 * Validator
 * @author zhuhaipeng6 in 2020/2/25
 * @version 1.0
 **/
public interface Validator<T extends Annotation> {

    /**
     * 获取类型
     * @return
     */
    Class<T> support();

    /**
     * 校验
     * @param obj
     * @param field
     */
    void validate(Object obj, Field field);
}
