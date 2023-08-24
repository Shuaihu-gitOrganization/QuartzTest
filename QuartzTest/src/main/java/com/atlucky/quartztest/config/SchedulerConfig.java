package com.atlucky.quartztest.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @Date 2023/8/22 13:22
 * @Author XiaoHu
 * @Description
 **/
@Configuration
public class SchedulerConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        return schedulerFactoryBean().getScheduler();
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException{
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setSchedulerName("cluster_scheduler");
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("application");
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setTaskExecutor(getSchedulerThreadPoolConfig());
        schedulerFactoryBean.setStartupDelay(0);
        return schedulerFactoryBean;
    }

    @Bean
    public Properties quartzProperties()throws IOException{
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(new ClassPathResource("/spring-quartz.properties"));
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public Executor getSchedulerThreadPoolConfig(){
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        threadPoolExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        threadPoolExecutor.setQueueCapacity(Runtime.getRuntime().availableProcessors());
        return (Executor) threadPoolExecutor;
    }
}
