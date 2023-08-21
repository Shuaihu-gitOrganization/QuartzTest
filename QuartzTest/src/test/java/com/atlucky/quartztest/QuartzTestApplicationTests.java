package com.atlucky.quartztest;

import com.atlucky.quartztest.quartz.MyJob;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class QuartzTestApplicationTests {
	@Resource
	private MyJob myJob;
	@Test
	void contextLoads() {
	}
	@Test
	public void testQuartz() throws SchedulerException {
		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group").build();
		Trigger build = TriggerBuilder.newTrigger()
				.withIdentity("trigger", "triggerGroup")
				.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1).repeatForever()).build();

		Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
		defaultScheduler.scheduleJob(job,build);
		defaultScheduler.start();
	}

}
