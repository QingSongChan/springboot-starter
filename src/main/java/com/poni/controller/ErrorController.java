package com.poni.controller;

import com.poni.utils.JsonResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *@author:PONI_CHAN
 *@date:2018/12/2 17:09
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error(){

        int a = 1 / 0;

        return "error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JsonResultUtil getAjaxerror() {

        int a = 1 / 0;

        return JsonResultUtil.ok();
    }
}
