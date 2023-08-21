package com.atlucky.quartztest.utils.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2023/8/21 11:02
 * @Author XiaoHu
 * @Description 定时任务线程池
 *
 **/
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        //引入线程池 不会出现线程阻塞 执行时间也会变得规律
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2 ; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new Task("task"+(i+1)),0,2, TimeUnit.SECONDS);
        }
    }


}
class Task implements Runnable{
private String taskName;

    Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("任务号"+taskName+" startTime"+new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("任务号"+taskName+" endTime"+new Date());

    }
}
