package com.poni.controller;

import com.poni.pojo.Resource;
import com.poni.utils.JsonResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author:PONI_CHAN
 *@date:2018/12/1 15:19
 */
@RestController
public class ResourceController {

    @Autowired
    public Resource resource;

    @GetMapping("/getResourceJsonResult")
    public JsonResultUtil getResourceJsonResult(){

        Resource bean=new Resource();
        BeanUtils.copyProperties(resource,bean);   //将对象resource放入bean返回

        return JsonResultUtil.ok(bean);

    }
}
