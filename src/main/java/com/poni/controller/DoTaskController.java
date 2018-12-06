package com.poni.controller;

import com.poni.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/*
 *@author:PONI_CHAN
 *@date:2018/12/5 22:04
 */
@RestController
@RequestMapping("/Async")
public class DoTaskController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test1")
    public String test1() throws Exception {

        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        //while循环需要消耗时间，总耗时要多几毫秒
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);

        return times;
    }
}
