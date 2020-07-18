package com.md.it.framework.exception;

/**
 * ErrorHelper
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class ErrorHelper {

    public ErrorHelper() {
    }

    public static PrjException buildExByCode(ErrorCode errorCode) {
        return new PrjException(errorCode.getCode(), errorCode.getMsg(), (String)null);
    }

    public static void genExByCode(ErrorCode errorCode) {
        throw new PrjException(errorCode.getCode(), errorCode.getMsg(), (String)null);
    }

    public static void illegalArg(String name, Object value) {
        throw new IllegalArgumentException(String.format("%s => %s", name, value));
    }

    public static void genExByCode(ErrorCode errorCode, String detail) {
        throw new PrjException(errorCode.getCode(), errorCode.getMsg(), detail);
    }

    public static void genExByCode(String viewName, ErrorCode errorCode) {
        throw new PrjException(viewName, errorCode.getCode(), errorCode.getMsg(), (String)null);
    }

    public static void genExByCode(String viewName, ErrorCode errorCode, String detail) {
        throw new PrjException(viewName, errorCode.getCode(), errorCode.getMsg(), detail);
    }
}
