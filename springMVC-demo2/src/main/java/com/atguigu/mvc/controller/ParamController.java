package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username : "+username+", password : "+password);
        return "success";
    }
    @RequestMapping("/testParam")
    public String testParam(
//            使用 @RequestParam注解 将请求参数与控制器方法的形参创建映射 , 此时 user_name 为前台表单 name ,username为形参
//            required 为设置其属性是否必须传输 value参数 , 默认为 true
//            defaultValue 为设置其默认值
            @RequestParam( value = "user_name",required = false,defaultValue = "hehe") String username,
            String password,
            String[] hobby,
//            @RequestHeader注解 获取请求头信息 , 并与形参创建映射关系
            @RequestHeader(value = "sayhh",required = true,defaultValue = "hh") String host,
//            @CookieValue注解 获取Cookie数据 , 并与形参创建映射关系
            @CookieValue("JSESSIONID") String JSESSIONID){
//        若出现多个同名参数 , 可在控制器形参部分使用字符串或字符串数组接收
//        若使用字符串类型,则使用 逗号->, 进行拼接
        System.out.println("username : "+username+", password : "+password+", hobby : "+ Arrays.toString(hobby));
        System.out.println("host "+host);
        System.out.println("JSESSIONID : "+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
//        直接通过实体类对象获取
        System.out.println(user);
        return "success";
    }
}
