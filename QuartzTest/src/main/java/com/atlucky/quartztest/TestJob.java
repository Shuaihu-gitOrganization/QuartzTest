package com.atlucky.quartztest;

import com.atlucky.quartztest.quartz.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Date 2023/8/21 17:27
 * @Author XiaoHu
 * @Description
 **/
public class TestJob {
    public static void main(String[] args) {
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group").build();
        Trigger build = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1).repeatForever()).build();

        Scheduler defaultScheduler = null;
        try {
            defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        try {
            defaultScheduler.scheduleJob(job,build);
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
