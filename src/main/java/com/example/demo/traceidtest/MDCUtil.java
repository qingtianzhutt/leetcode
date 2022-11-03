package com.example.demo.traceidtest;

import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @Description 封装MDC用于向线程池传递
 */
public class MDCUtil {

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (CollectionUtils.isEmpty(context)) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }

    public static void setMDCContextMap(final Map<String, String> context) {
        if (CollectionUtils.isEmpty(context)) {
            MDC.clear();
        } else {
            MDC.setContextMap(context);
        }
    }

}

