package com.poni.controller;

import com.poni.pojo.SysUser;
import com.poni.service.UserService;
import com.poni.utils.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/12/3 23:15
 */
@RestController
@RequestMapping("/mybatis")
public class CrudController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private Sid sid;

    @RequestMapping("/saveUser")
    public JsonResultUtil addUser() throws Exception {

//        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId("10011004");
        user.setUsername("poni-Abb" + new Date());
        user.setNickname("poni-Abb" + new Date());
        user.setPassword("abc123456");
        user.setIsDelete(0);                 //非空字段必须设置
        user.setRegistTime(new Date());      //非空字段必须设置
        System.out.println(123456);
        userService.addUser(user);

        return JsonResultUtil.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JsonResultUtil updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("poni-updated" + new Date());
        user.setNickname("poni-updated" + new Date());
        user.setPassword("66668888");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return JsonResultUtil.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public JsonResultUtil deleteUser(String userId) {

        userService.deleteUser(userId);

        return JsonResultUtil.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JsonResultUtil queryUserById(String userId) {

        return JsonResultUtil.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JsonResultUtil queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return JsonResultUtil.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JsonResultUtil queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }
        int pageSize = 10;

        SysUser user = new SysUser();

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JsonResultUtil.ok(userList);
    }

    @RequestMapping("/queryUserByAge/{age}")
    public JsonResultUtil queryUserByIdCustom(@PathVariable("age")Integer age) {

        return JsonResultUtil.ok(userService.queryUserByAge(age));
    }

    @RequestMapping("/saveUserTransactional")
    public JsonResultUtil saveUserTransactional() {

        SysUser user = new SysUser();
        user.setId("10011004");
        user.setUsername("poni2" + new Date());
        user.setNickname("poni2" + new Date());
        user.setPassword("qaz668899");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return JsonResultUtil.ok("保存成功");
    }
}
