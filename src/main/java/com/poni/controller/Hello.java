package com.poni.controller;

/*
 *@author:PONI_CHAN
 *@date:2018/11/28 11:00
 */

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/Hello")

public class Hello {

    @GetMapping("/hello")
    public String say(){
        return "hello springboot2!!";
    }

//    @GetMapping("/test")
//    public String test(){
        //验证客户端的信息

        //正确无误后调用第三方接口

        //然后把第三方接口的返回信息解析加工返回客户端
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//
//        try {
//            HttpPost httpPost = new HttpPost("http://httpbin.org/");
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("api_key","XXX");
//            jsonObject.put("api_secret","XXX");
//            jsonObject.put("api_key","XXX");
//            httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
//            HttpEntity httpEntity = new StringEntity(jsonObject.toString(),"utf-8");
//            httpPost.setEntity(httpEntity);
//            //HttpGet httpget = new HttpGet("http://httpbin.org/");
//
//            //System.out.println("Executing request " + httpget.getRequestLine());
//
//            // Create a custom response handler
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//                @Override
//                public String handleResponse(
//                        final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        HttpEntity entity = response.getEntity();
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//
//            };
//            String responseBody = null;
//            HttpResponse httpResponse = httpclient.execute(httpPost);
//
//            try {
//                responseBody = httpclient.execute(httpPost, responseHandler);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
//            JSONObject result = new JSONObject(responseBody);
//            String gender = result.get("gender");
//
//        } finally {
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
