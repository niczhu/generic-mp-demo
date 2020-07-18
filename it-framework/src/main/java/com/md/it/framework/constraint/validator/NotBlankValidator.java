package com.md.it.framework.constraint.validator;

import com.md.it.framework.constraint.annotation.NotBlank;
import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.ErrorHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * NotBlankValidator
 *
 * @author zhuhaipeng6 in 2020/2/26 10:34
 * @version 1.0
 **/
public class NotBlankValidator extends AbstractValidator<NotBlank, Object> {
    @Override
    void doValidate(Object fieldValue, NotBlank annotation, String fieldName) {
        if (StringUtils.isBlank(String.valueOf(fieldValue))) {
            String propName = StringUtils.isBlank(annotation.propName()) ? fieldName : annotation.propName();
            ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("%s不能为空", propName));
        }
    }

    @Override
    public Class support() {
        return NotBlank.class;
    }
}
