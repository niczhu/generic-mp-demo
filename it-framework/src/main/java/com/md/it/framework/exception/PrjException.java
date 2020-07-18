package com.md.it.framework.exception;

/**
 * PrjException
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class PrjException extends BasePrjException {

    private static final long serialVersionUID = -7576992670473664947L;
    private String code;
    private String detail;
    private String viewName;

    public PrjException(String code, String msg, String detail) {
        super(msg);
        this.code = code;
        this.detail = detail;
    }

    public PrjException(String viewName, String code, String msg, String detail) {
        this(code, msg, detail);
        this.viewName = viewName;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
