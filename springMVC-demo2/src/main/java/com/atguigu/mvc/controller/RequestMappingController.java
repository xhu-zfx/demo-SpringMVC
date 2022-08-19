package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
//    RequestMapping value设置为数组时 可同时处理多个请求
//    RequestMapping method设置为数组时 可同时处理多个请求方式

    @RequestMapping(
            value = {"/testRequestMapping","/test" },
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String success(){
        return "success";
    }
    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }
    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }
    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username"},
            headers = {"Host=localhost:8081"})
    public String testParamsAndHeaders(){
        return "success";
    }
//    @RequestMapping("/a?a/testAnt")      //? 匹配单个字符
    @RequestMapping("/a*a/testAnt")     // * 匹配 0个或多个字符
//    @RequestMapping("/a**a/testAnt")    // ** 匹配任意一层或多层目录
    public String testAnt(){
        return "success";
    }
    @RequestMapping("testPath/{id}/{username}")
    public String testPath(@PathVariable(value = "id")Integer id,@PathVariable("username") String username){
        System.out.println("id: "+id+"  username: "+username);
        return "success";
    }
}
