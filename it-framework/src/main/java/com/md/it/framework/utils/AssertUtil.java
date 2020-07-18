package com.md.it.framework.utils;

import com.md.it.framework.exception.ErrorCode;
import com.md.it.framework.model.TableFieldEnum;
import com.md.it.framework.exception.ErrorHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/***
  * 断言工具类
  * @author  zhuhaipeng6
  **/
@Slf4j
public class AssertUtil {
    public AssertUtil() {
    }

    public static void equals(String str1, String str2, ErrorCode errorCode) {
        if (!StringUtils.equals(str1, str2)) {
            log.info("[{}] equals [{}] 不通过,{}", str1, str2, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }

    }

    public static void equals(TableFieldEnum enum1, TableFieldEnum enum2, ErrorCode errorCode) {
        if (enum1 == null || enum2 == null) {
            log.info("[{}] equals [{}]不通过,{}", enum1, enum2, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }

        if (!StringUtils.equals(enum1.getCode(), enum2.getCode())) {
            log.info("[{}] equals [{}]不通过,{}", enum1, enum2, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }

    }

    public static void notBlank(String s, ErrorCode errorCode) {
        if (StringUtils.isBlank(s)) {
            log.info("notBlank不通过,[{}]是空字符串,{}", s, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }

    }

    public static void notNull(Object obj, ErrorCode errorCode) {
        if (obj == null) {
            log.info("notNull不通过,[{}]是null,{}", obj, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }
    }

    public static void isTrue(boolean result, ErrorCode errorCode) {
        if (!result) {
            log.info("isTrue不通过,[{}]结果是false,{}", result, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }
    }

    public static void isNull(Object obj, ErrorCode errorCode) {
        if (obj != null) {
            log.info("isNull不通过,[{}]不是null,{}", obj, Thread.currentThread().getStackTrace()[2]);
            ErrorHelper.genExByCode(errorCode);
        }
    }

}
