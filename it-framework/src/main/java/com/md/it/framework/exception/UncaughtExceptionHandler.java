package com.md.it.framework.exception;

import com.md.it.framework.thread.PrjThread;
import lombok.extern.slf4j.Slf4j;

/**
 * 未捕获异常处理类
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
@Slf4j
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t.getClass() == PrjThread.class) {
            log.warn("异步线程{}出现异常[{}],extra={}", t, ((PrjThread) t).getTraceId(), ((PrjThread) t).getExtra());
        } else {
            log.warn("异步线程{}出现异常", t);
        }
    }
}
