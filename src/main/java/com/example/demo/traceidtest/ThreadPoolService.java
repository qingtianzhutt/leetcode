package com.example.demo.traceidtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolService {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (4, 8, 10,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5536),
                        new ScheduledExecutorFactoryBean(), new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolExecutor;
    }

}

