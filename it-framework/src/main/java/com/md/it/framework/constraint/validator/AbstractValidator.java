package com.md.it.framework.constraint.validator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * AbstractValidator
 *
 * @author zhuhaipeng6 in 2020/2/25
 * @version 1.0
 **/
@Slf4j
public abstract class AbstractValidator<T, VT> implements Validator {
    public AbstractValidator() {
    }

    public void validate(Object obj, Field field) {
        Class annoClass = this.support();
        Annotation annotation = field.getAnnotation(annoClass);

        try {
            VT value = (VT) FieldUtils.readField(field, obj, true);
            this.doValidate(value, (T) annotation, field.getName());
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error("Validator exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    abstract void doValidate(VT fieldValue, T annotation, String fieldName);
}
