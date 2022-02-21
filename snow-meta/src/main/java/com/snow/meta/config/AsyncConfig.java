package com.snow.meta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步调用配置
 *
 */
@Configuration
public class AsyncConfig {

    public static final String EXECUTOR_NAME = "asyncTaskExecutor";

    public static final String TASK_QUARTZ_EXECUTOR_NAME = "taskQuartzExecutor";

    private static final int MAX_POOL_SIZE = 20;

    private static final int CORE_POOL_SIZE = 5;

    private static final int QUEUE_CAPACITY = 20;

    @Bean(EXECUTOR_NAME)
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }


    /**
     * 定时任务处理使用的线程池（不包括实时任务）
     *
     * @return
     */
    @Bean(TASK_QUARTZ_EXECUTOR_NAME)
    public AsyncTaskExecutor getTaskQuartzExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(2);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(5);
        //活跃时间
        executor.setKeepAliveSeconds(60 * 15);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("-task-quartz-async-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
