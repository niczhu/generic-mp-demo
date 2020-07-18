package com.md.it.framework.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * RequestUtil
 *
 * @author zhuhaipeng6 in 2020/2/25 20:47
 * @version 1.0
 **/
@Slf4j
public class ResponseUtil {

    /**
     * json异常返回
     * @param response
     * @param output
     */
    public static void ajaxResponseException(HttpServletResponse response, Map<String,Object> output){
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            if (writer != null) {
                writer.write(JSONObject.toJSONString(output));
                writer.close();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }
}
