package com.md.it.framework.support.converter;

import com.alibaba.fastjson.serializer.EnumSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.md.it.framework.model.TableFieldEnum;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * TableFieldEnumSerializer
 *
 * @author zhuhaipeng6 in 2020/2/26 17:30
 * @version 1.0
 **/
public class TableFieldEnumSerializer extends EnumSerializer {
    static {
        System.out.println("加载 TableFieldEnumSerializer");
    }
    public TableFieldEnumSerializer() {
    }

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        super.write(serializer, object, fieldName, fieldType, features);
        serializer.getWriter().writeFieldValue(',', String.format("%sDesc", fieldName), ((TableFieldEnum) object).getDesc());
    }

}
