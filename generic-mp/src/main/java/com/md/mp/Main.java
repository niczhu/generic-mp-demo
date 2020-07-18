package com.md.mp;

import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.vo.MpAccountVo;
import com.md.mp.framwork.utils.ConverterUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Main
 *
 * @author zhuhaipeng6 in 2020/7/18 16:39
 * @version 1.0
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        MpAccountVo mpAccountVo = new MpAccountVo();
        mpAccountVo.setPin("9");
        mpAccountVo.setName("9");
//        mpAccountVo.setAge(0);
        mpAccountVo.setId(0);

        MpAccountVo vo2 = new MpAccountVo();
        ConverterUtil.copy(mpAccountVo, vo2);

        System.out.println(mpAccountVo);
        System.out.println(vo2);

        MpAccountVo vo = new MpAccountVo();
        int value = vo.getAge();
        System.out.println(!Integer.class.isInstance(value));
        System.out.println( (Integer)value != 0);

    }

    @Getter
    @Setter
    @ToString
    public static class Test {
        public Test() {
        }

        private Integer a;
        private Double b;
        private int aa;
        private double bb;

    }
}
