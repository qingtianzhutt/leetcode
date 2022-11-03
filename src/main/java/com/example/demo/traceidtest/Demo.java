package com.example.demo.traceidtest;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用MDC传递traceId
 */
public class Demo {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    public void demo() {
        ExecutorCompletionService ecs = new ExecutorCompletionService(threadPoolExecutor);
        ecs.submit(MDCUtil.wrap(new TestMDC(), MDC.getCopyOfContextMap()));
    }

    class TestMDC implements Callable {
        @Override
        public Object call() throws Exception {
            // TODO 代码逻辑
            System.out.println(1111);
            System.out.println(2222);
            System.out.println(3333);
            return null;
        }
    }

}

