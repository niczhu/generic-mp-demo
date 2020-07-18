package com.md.it.framework.exception;

/**
 * BasePrjException
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class BasePrjException extends RuntimeException{

    public BasePrjException(){}

    public BasePrjException(String msg){
        super(msg);
    }

}
