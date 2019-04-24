package shenzhen.teamway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: aspectthreaddemo
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-04-19 09:21
 **/
@Configuration
@EnableAsync
public class ThreadConfig {
    /**
     * @Author: Zhao Hong Ning
     * @Description:创建的线程池在spring容器里默认的名字是方法名
     * @Date:  2019/4/19
     * @param:
     * @return: java.util.concurrent.ExecutorService
    */
    @Bean
    public ExecutorService pool() {
        final ExecutorService pool = Executors.newFixedThreadPool(10);
        return pool;
    }
}