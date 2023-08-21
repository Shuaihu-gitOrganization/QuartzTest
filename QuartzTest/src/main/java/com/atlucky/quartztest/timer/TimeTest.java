package com.atlucky.quartztest.timer;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

/**
 * @Date 2023/8/21 10:44
 * @Author XiaoHu
 * @Description
 **/
@Slf4j
public class TimeTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        for (int i = 0; i < 2; i++) {
            Task task = new Task("任务" + (i + 1));
            //单线程执行，会出现线程阻塞
            timer.schedule(task,new Date(),2000);//延后执行
           // timer.scheduleAtFixedRate(task,new Date(),2000);//执行时间错乱
        }
    }
}
class Task extends TimerTask{
    private String taskName;

    Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("当前任务名"+taskName+"startTime"+new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("当前任务名"+taskName+"endTime"+new Date());
    }
}


