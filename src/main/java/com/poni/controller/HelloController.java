package com.poni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //通过web访问的话必须加上此标签

@RequestMapping("/Hello")
public class HelloController {

//    @RequestMapping(value = {"/say"},method = RequestMethod.GET) //与GetMapping一样的效果
    @GetMapping(value = "/say")
    public String say(@RequestParam(value="id",required = false,defaultValue = "0") Integer myid){
        return "id是"+myid;

//        return girlProperties.getCupSize();
    }
}
