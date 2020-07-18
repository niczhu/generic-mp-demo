package com.md.it.framework.constraint.validator;

import com.md.it.framework.constraint.annotation.Length;
import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.ErrorHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * LengthValidator
 *
 * @author zhuhaipeng6 in 2020/2/26 10:51
 * @version 1.0
 **/
public class LengthValidator extends AbstractValidator<Length, Integer> {
    @Override
    void doValidate(Integer fieldValue, Length annotation, String fieldName) {
        String propName = StringUtils.isNotBlank(annotation.propName()) ? annotation.propName() : fieldName;

        /**
             if (fieldValue <= 0) {
             ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("%s不能为空", propName));
             }
         */

        if (annotation.value() > 0) {
            if (annotation.value() != String.valueOf(fieldValue).length()) {
                ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("%s不是%d位", propName, annotation.value()));
            }
        } else {
            // min与max
            if (annotation.min() > 0 && String.valueOf(fieldValue).length() < annotation.min()) {
                ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("%s最短%d位", propName, annotation.value()));
            }
            if (annotation.max() > 0 && String.valueOf(fieldValue).length() > annotation.max()) {
                ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("%s最长%d位", propName, annotation.value()));
            }
        }
    }

    @Override
    public Class support() {
        return Length.class;
    }
}
