package com.md.it.framework.exception.handler;

import com.md.it.framework.exception.ErrorCode;
import com.md.it.framework.exception.PrjException;

import java.util.HashMap;
import java.util.Map;

/**
 * AbstructExceptionHandler
 *
 * @author zhuhaipeng6 in 2020/2/25 20:12
 * @version 1.0
 **/
public class BaseExceptionHandler {

    final String CODE = "code";
    final String MSG = "msg";
    final String DETAIL = "detail";
    final String SUCCESS = "success";
    final String RESULT = "result";

    public BaseExceptionHandler() {
    }

    protected Map<String, Object> getResponseMap(ErrorCode errorCode, String detail) {
        Map<String, Object> map = new HashMap<>();
        map.put(CODE, errorCode.getCode());
        map.put(MSG, errorCode.getMsg());
        map.put(DETAIL, detail);
        map.put(SUCCESS, false);
        return map;
    }

    protected Map<String, Object> getResponseMap(ErrorCode errorCode, Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put(CODE, errorCode.getCode());
        map.put(MSG, errorCode.getMsg());
        map.put(DETAIL, ex.getMessage());
        map.put(SUCCESS, false);
        return map;
    }

    protected Map<String, Object> getResponseMap(PrjException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put(CODE, ex.getCode());
        map.put(MSG, ex.getMessage());
        map.put(DETAIL, ex.getDetail());
        map.put(SUCCESS, false);
        return map;
    }


}
