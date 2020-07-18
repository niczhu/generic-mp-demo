package com.md.it.framework.constraint.service;

import com.md.it.framework.constraint.annotation.Length;
import com.md.it.framework.constraint.annotation.NotBlank;
import com.md.it.framework.constraint.annotation.NotNull;
import com.md.it.framework.constraint.validator.LengthValidator;
import com.md.it.framework.constraint.validator.NotBlankValidator;
import com.md.it.framework.constraint.validator.NotNullValidator;
import com.md.it.framework.constraint.validator.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ValidatorServiceImpl
 *
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class ValidatorServiceImpl implements ValidatorService {

    private static final Map<Class<?>, Validator<?>> validatorMap = new ConcurrentHashMap();

    static {
        validatorMap.put(NotNull.class, new NotNullValidator());
        validatorMap.put(NotBlank.class, new NotBlankValidator());
        validatorMap.put(Length.class, new LengthValidator());
    }

    public ValidatorServiceImpl() {
    }

    public static Map<Class<?>, Validator<?>> getValidatorMap() {
        return validatorMap;
    }


    @Override
    public void validate(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] fields = declaredFields;
        int len = declaredFields.length;

        // 迭代校验每一个属性
        for (int i = 0; i < len; i++) {
            Field field = fields[i];
            Annotation[] annotations = field.getAnnotations();
            Annotation[] annos = annotations;
            int annoLen = annotations.length;

            for (int j = 0; j < annoLen; j++) {
                Annotation anno = annos[j];
                Validator<?> validator = (Validator) validatorMap.get(anno.annotationType());
                if (null != validator) {
                    validator.validate(obj, field);
                }
            }

        }
    }

}
