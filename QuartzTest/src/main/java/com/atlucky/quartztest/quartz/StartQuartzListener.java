package com.atlucky.quartztest.quartz;

import com.atlucky.quartztest.config.SchedulerConfig;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Date 2023/8/22 13:50
 * @Author XiaoHu
 * @Description
 **/
@Component
public class StartQuartzListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private Scheduler scheduler;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "triggergroup");
        try {
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if(Objects.isNull(trigger)){
                trigger= TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                        .build();
                JobDetail jobDetail = JobBuilder
                        .newJob(QuartzJob.class)
                        .withIdentity("job1", "JobGroup")
                        .build();
                scheduler.scheduleJob(jobDetail,trigger);
                scheduler.start();
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
