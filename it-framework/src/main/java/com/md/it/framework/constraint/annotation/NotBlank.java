package com.md.it.framework.constraint.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * NotBlank
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotBlank {

    /**
     * 属性名称
     */
    String propName() default "";

}
