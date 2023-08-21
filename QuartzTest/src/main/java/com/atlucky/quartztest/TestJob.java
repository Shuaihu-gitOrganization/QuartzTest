package com.atlucky.quartztest;

import com.atlucky.quartztest.quartz.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2023/8/21 17:27
 * @Author XiaoHu
 * @Description
 **/
public class TestJob {
    public static void main(String[] args) {
        Map<String, String> jobMap = new HashMap<>();
        jobMap.put("test","job");
        Map<String, String> triggerMap = new HashMap<>();
        triggerMap.put("trigger","triggerMap");
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1","group")
                .usingJobData("test","job")
                .usingJobData("name","job")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .usingJobData("trigger","trigger")
                .usingJobData("name","trigger")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1).repeatForever()).build();

        Scheduler defaultScheduler = null;
        try {
            defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        try {
            defaultScheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        try {
            defaultScheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
