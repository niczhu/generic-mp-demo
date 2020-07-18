package com.md.it.framework.support.converter;

import com.md.it.framework.model.TableFieldEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * JsonHttpMessageConverter
 *
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
@Slf4j
public class PrjJsonHttpMessageConverter extends com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter {

    public PrjJsonHttpMessageConverter() {
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("result", "0");
        map.put("data", obj);
        super.writeInternal(map, outputMessage);
    }

    public void filterField(Object obj){
        // enum serializer
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if ((field.get(obj)) instanceof TableFieldEnum) {
                    System.out.println("TableFieldEnum->"+field.get(obj));
                }
            } catch (IllegalAccessException e) {
                log.error("error:");
            }
        }
    }
}
