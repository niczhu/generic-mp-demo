package com.md.it.framework.constraint.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Length
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {

    int value() default -1;

    /**
     * 最小值
     * @return
     */
    int min() default -1;

    /**
     * 最大值
     * @return
     */
    int max() default -1;

    /**
     * 属性名称
     * @return
     */
    String propName() default "";
}
