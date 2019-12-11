package cn.study.springbootthreadpool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: ThreadPoolConfig
 * @author: 10724
 * @date: Created in 2019/11/12
 * @Description:
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig{

    @Bean
    public Executor defaultThreadPool() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        //设置初始核心线程数
        executor.setCorePoolSize(5);
        //最大线程数
        executor.setMaxPoolSize(15);
        //线程名称前缀
        executor.setThreadNamePrefix("defaultThreadPool_");
        //任务列表
        executor.setQueueCapacity(30);
        //任务执行策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后的最大存活时间
        executor.setKeepAliveSeconds(60);
        //初始化线程池
        executor.initialize();
        return executor;
    }
}
