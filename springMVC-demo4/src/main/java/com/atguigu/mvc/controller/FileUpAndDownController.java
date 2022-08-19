package com.atguigu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        System.out.println(realPath);
        InputStream is = new FileInputStream(realPath);
//        available获取 文件长度
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String,String> headers = new HttpHeaders();
//        设置下载方式和下载文件名
        headers.add("Content-Disposition","attachement;filename=1.jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, status);
        is.close();
        return responseEntity;
    }
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
//        获取文件名
        String fileName = photo.getOriginalFilename();
//        获取文件后缀
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
//        将uuid作为文件名
        ServletContext servletContext = session.getServletContext();
        String uuid= UUID.randomUUID().toString();
        fileName=uuid+suffixName;
        String realPath = servletContext.getRealPath("photo");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath=realPath+File.separator+fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
