package com.poni.exception;

/*
 *@author:PONI_CHAN
 *@date:2018/12/2 17:39
 */

import com.poni.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonResultUtil defaultErrorHandler(HttpServletRequest req,Exception e) throws  Exception{

        e.printStackTrace();
        return JsonResultUtil.errorException(e.getMessage());

    }

}
