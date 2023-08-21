package com.atlucky.quartztest.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Date 2023/8/21 11:40
 * @Author XiaoHu
 * @Description
 **/
@Slf4j
@Component
public class MyJob implements Job {
    private String value;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//      log.info("{}","Job Executor"+new Date());
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        System.out.println(jobDataMap.get("test"));
        System.out.println(triggerDataMap.get("trigger"));
        System.out.println(mergedJobDataMap.get("test"));
        System.out.println(mergedJobDataMap.get("name"));

    }

    public void setValue(String value) {
        this.value = value;
    }
}
