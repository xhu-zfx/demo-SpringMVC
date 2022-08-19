package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpConroller {
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity <String> requestEntity){
        System.out.println("请求头 requestHeaders = " + requestEntity.getHeaders());
        System.out.println("请求体 requestBody = " + requestEntity.getBody());
        return "success";
    }
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().println("hello response");
    }
    @RequestMapping("/testResponseBody")
//    @ResponseBody 注解直接将返回值作为响应对象
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }
    @RequestMapping("testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",22,"男");
    }
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println("username = " + username + ", password = " + password);
        return "hello,axios";
    }
}
