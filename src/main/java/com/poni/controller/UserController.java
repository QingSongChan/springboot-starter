package com.poni.controller;

/*
 *@author:PONI_CHAN
 *@date:2018/11/29 10:53
 */

import com.poni.pojo.User;
import com.poni.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @GetMapping("/hello")
    public User Hello(){

        User u=new User();
        u.setName("PONI_CHAN2");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("66669999");
        u.setDesc(null);

        return u;
    }

    /**
     *  对json数据进行封装，呈现状态码与返回值，在Util类里声明
     * @author chenmc
     * @date 2018/11/29 15:03:09
     * @param
     * @return com.poni.utils.JsonResultUtil
     */
    @GetMapping("/getUserjson")
    public JsonResultUtil getUserJson(){

        User u=new User();
        u.setName("PONI_CHAN");
        u.setAge(19);
        u.setBirthday(new Date());
        u.setPassword("66668888");
        u.setDesc("Hello ponichan");

        return JsonResultUtil.ok(u);
    }
}
