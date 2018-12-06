package com.poni.controller;

import com.poni.pojo.SysUser;
import com.poni.pojo.User;
import com.poni.utils.JsonResultUtil;
import com.poni.utils.RedisJsonResultUtil;
import com.poni.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/12/5 10:54
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    //注入一个String类型方法来调用
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping("/test1")
    public JsonResultUtil redisTest1(){

        //设置一个key-value,存放字符串
        stringRedisTemplate.opsForValue().set("poni-cache","hello ponichan");

        return JsonResultUtil.ok(stringRedisTemplate.opsForValue().get("poni-cache"));

    }

    @RequestMapping("/test2")
    public JsonResultUtil redisTest2(){

        //用json字符串存放对象
        SysUser user = new SysUser();
        user.setId("10011008");
        user.setUsername("poni8" );
        user.setNickname("poni8" );
        user.setPassword("qaz668899");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        stringRedisTemplate.opsForValue().set("json:user", RedisJsonResultUtil.objectToJson(user));

        SysUser redisUser=RedisJsonResultUtil.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"),SysUser.class);

        return JsonResultUtil.ok(redisUser);
    }

    @RequestMapping("/test3")
    public JsonResultUtil redisTest3(){

        User u1 = new User();
        u1.setAge(19);
        u1.setName("charles1");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello charles2");
        u2.setPassword("123456");
        u2.setBirthday(new Date());


        User u3 = new User();
        u3.setAge(18);
        u3.setName("charles3");
        u3.setPassword("123456");
        u3.setBirthday(new Date());

        List<User> userList = new ArrayList<>();

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        redisOperator.set("json:userlist",RedisJsonResultUtil.objectToJson(userList),2000);

        List<User> userlist=RedisJsonResultUtil.jsonToList(redisOperator.get("json:userlist"),User.class);

        return JsonResultUtil.ok(userlist);

    }


}
