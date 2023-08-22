package com.atlucky.quartztest.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Date 2023/8/21 11:40
 * @Author XiaoHu
 * @Description
 **/
@Slf4j
@Component
@DisallowConcurrentExecution //禁止并发的执行同一个job定义的多个实例
@PersistJobDataAfterExecution //持久化JobDetail中的JobDataMap（对trigger中的JobData失效）
public class MyJob implements Job {
    private String value;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//      log.info("{}","Job Executor"+new Date());
//        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
//        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
//        System.out.println(jobDataMap.get("test"));
//        System.out.println(triggerDataMap.get("trigger"));
//        System.out.println(mergedJobDataMap.get("test"));
//        System.out.println(mergedJobDataMap.get("name"));

       /* log.info("{}",System.identityHashCode(context.getJobDetail()));
        log.info("{}",System.identityHashCode(context.getJobInstance()));*/
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        jobDataMap.put("count",jobDataMap.getInt("count") + 1);
        System.out.println(jobDataMap.getInt("count"));
        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
        triggerDataMap.put("count",triggerDataMap.getInt("count") + 1);
        System.out.println(triggerDataMap.getInt("count"));//不会生效

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void setValue(String value) {
        this.value = value;
    }
}
