package com.md.it.framework.constraint.validator;

import com.md.it.framework.constraint.annotation.NotNull;
import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.ErrorHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * NotNullValidator
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class NotNullValidator extends AbstractValidator<NotNull, Object> {

    @Override
    void doValidate(Object fieldValue, NotNull annotation, String fieldName) {
        if (null == fieldValue) {
            String prop = annotation.propName();
            if (StringUtils.isBlank(prop)) {
                prop = fieldName;
            }
            ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("[%s]不能为空", prop));
        }
    }

    @Override
    public Class<NotNull> support() {
        return NotNull.class;
    }
}
