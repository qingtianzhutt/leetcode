//package com.example.demo.utils;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * 异步线程池
// * @author cs
// *
// */
//@Configuration
//@EnableAsync
//@Component
//public class ThreadPoolConfig {
//
//    @Value("${corepoolsize}")
//    private int corePoolSize;//核心线程数
//
//    @Value("${maxpoolsize}")
//    private int maxPoolSize;//最大线程数
//
//    @Value("${queuecapacity}")
//    private int queueCapacity;//队列最大长度
//
//    @Value("${keepaliveseconds}")
//    private int keepAliveSeconds;//线程池维护线程所允许的空闲时间
//
//    private ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();//线程池对拒绝任务(无线程可用)的处理策略
//
//    private String threadNamePrefix = "AsyncExecutorThread-";
//
//    @Bean(name = "taskExecutor")
//    public ThreadPoolTaskExecutor asyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(corePoolSize);
//        executor.setMaxPoolSize(maxPoolSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setKeepAliveSeconds(keepAliveSeconds);
//        executor.setRejectedExecutionHandler(callerRunsPolicy);
//        executor.setThreadNamePrefix(threadNamePrefix);
//        executor.setRejectedExecutionHandler(callerRunsPolicy);
//        executor.initialize();
//        return executor;
//    }
//
//}
//
