package com.example.demo.common.util;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * @author jincong
 * @date 2019/8/28
 */
public class ErrorUtils {
    private static FastThreadLocal<Throwable> throwableInfo = new FastThreadLocal<>();

    public static void setThrowable(Throwable throwable) {
        throwableInfo.set(throwable);
    }

    public static void clearThrowable() {
        throwableInfo.remove();
    }

    public static Throwable getThrowable() {
        return throwableInfo.get();
    }
}
