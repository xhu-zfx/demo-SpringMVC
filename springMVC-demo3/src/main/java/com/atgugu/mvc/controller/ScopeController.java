package com.atgugu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.applet.AppletContext;
import java.util.Map;

@Controller
public class ScopeController {
    @RequestMapping("/testRequestByServletAPI")
//    使用 testRequestByAPI 向 request 域共享数据
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScpoe" ,"hello,servletAPI");
        return "success";
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("testRequestScpoe","hello,ModelAndView");
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScpoe","hello,Model");
        System.out.println("model = " + model.getClass().getName());

        return "success";
    }
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScpoe","hello,Map");
        System.out.println("map = " + map.getClass().getName());
        return "success";
    }
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScpoe","hello,ModelMap");
        System.out.println("modelMap = " + modelMap.getClass().getName());

        return "success";
    }
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,Session");
        return "success";
    }
    @RequestMapping("testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,Application");
        return "success";
    }
}
