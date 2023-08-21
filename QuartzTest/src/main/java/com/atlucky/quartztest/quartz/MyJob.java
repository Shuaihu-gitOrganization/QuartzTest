package com.atlucky.quartztest.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
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
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
      log.info("{}","Job Executor"+new Date());
    }
}
