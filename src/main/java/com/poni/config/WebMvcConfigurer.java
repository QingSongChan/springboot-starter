package com.poni.config;

import com.poni.controller.Interceptor.OneInterceptor;
import com.poni.controller.Interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 *@author:PONI_CHAN
 *@date:2018/12/5 22:20
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按顺序执行
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

//        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**");

        /**
         * 同时被两个拦截器拦截
         */
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                                                      .addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }
}
