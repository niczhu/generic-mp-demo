package com.md.it.framework.thread;

/**
 * PrjThread
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class PrjThread  extends Thread {

    private String traceId;
    private Object extra;

    public PrjThread(Runnable runnable, String traceId) {
        super(runnable);
        this.traceId = traceId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
