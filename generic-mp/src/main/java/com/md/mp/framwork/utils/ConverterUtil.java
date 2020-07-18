package com.md.mp.framwork.utils;

import io.swagger.models.AbstractModel;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;


/**
 * ObjectUtil
 *
 * @author zhuhaipeng6 in 2020/7/1 21:28
 * @version 1.0
 **/
public class ConverterUtil {

    /**
     * TODO:可做成独立类，支持扩展
     *
     * @param descObject
     * @param resObject
     */
    public static void copyProperties(Object descObject, Object resObject) {
        try {
            PropertyUtils.copyProperties(descObject, resObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 数组转换
     *
     * @param dClass        目标类型
     * @param origClassList 原始数组
     * @param <D>
     * @return
     */
    public static <D> List<D> objConvertList(Class<D> dClass, List<?> origClassList) {
        List<D> desList = new ArrayList<D>();
        if (null != origClassList && !origClassList.isEmpty()) {
            for (Object origin : origClassList) {
                D d = objConvert(dClass, origin);
                desList.add(d);
            }
        }
        return desList;
    }

    /**
     * 类型转换
     *
     * @param dClass
     * @param origClass
     * @param <D>
     * @return
     */
    public static <D> D objConvert(Class<D> dClass, Object origClass) {
        D des = null;
        try {
            des = dClass.newInstance();
            if (origClass != null) {
                copyProperties(des, origClass);
            }
            return (D) des;
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void copy(Object source, Object target) {
        if (null == source || null == target) {
            return;
        }
        if (source.getClass() == target.getClass()) {
            if (AbstractModel.class.isInstance(target)) {
                AbstractModel sourceObj = (AbstractModel) source;
                AbstractModel targetObj = (AbstractModel) target;
//                if (!sourceObj.getExtInfo().isEmpty()) {
//                    targetObj.getExtInfo().putAll(sourceObj.getExtInfo());
//                    sourceObj.getExtInfo().putAll(targetObj.getExtInfo());
//                }
            }

            Class<?> actualEditable = target.getClass();
            PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
            PropertyDescriptor[] var4 = targetPds;
            int var5 = targetPds.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor targetPd = var4[var6];
                Method writeMethod = targetPd.getWriteMethod();
                if (writeMethod != null) {
                    PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                    if (sourcePd != null) {
                        Method readMethod = sourcePd.getReadMethod();
                        if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                            try {
                                if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                    readMethod.setAccessible(true);
                                }

                                Object value = readMethod.invoke(source);
                                if (value != null && (!Map.class.isInstance(value) || !((Map) value).isEmpty()) && (!Integer.class.isInstance(value) || (Integer) value != 0)) {
                                    if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                        writeMethod.setAccessible(true);
                                    }

                                    writeMethod.invoke(target, value);
                                }
                            } catch (Throwable var12) {
                                throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var12);
                            }
                        }
                    }
                }
            }

        }
    }

}
