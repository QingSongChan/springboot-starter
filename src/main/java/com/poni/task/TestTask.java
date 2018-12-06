package com.poni.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@author:PONI_CHAN
 *@date:2018/12/5 21:52
 */
@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
    //springboot不支持年，只允许六位
	@Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
