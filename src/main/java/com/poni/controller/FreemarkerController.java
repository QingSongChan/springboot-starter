package com.poni.controller;

/*
 *@author:PONI_CHAN
 *@date:2018/12/2 10:04
 */

import com.poni.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);        //这里的ModelMap  相当于ModelAndView
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }

}
