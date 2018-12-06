package com.poni.exception;

import com.poni.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *@author:PONI_CHAN
 *@date:2018/12/2 17:08
 */
@ControllerAdvice   //定义统一的Controller异常处理类
public class AllExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";  //返回error页面

	//@ExceptionHandler(value = Exception.class)     //Exception代表全局异常捕获
//    public Object errorHandler(HttpServletRequest reqest,
//                               HttpServletResponse response, Exception e) throws Exception {
//
//    	e.printStackTrace();
//
//		ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", reqest.getRequestURL());
//        mav.setViewName(IMOOC_ERROR_VIEW);
//        return mav;
//    }

    //同时兼容web与ajax的全局异常捕获
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(request)) {
            return JsonResultUtil.errorException(e.getMessage());   //返回的值是Object,不能直接response
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

    //判断是否为ajax请求的方法
    private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With")!=null
                && "XMLHttpRequest"
                .equals(request.getHeader("X-Requested-With").toString()));

    }
}
