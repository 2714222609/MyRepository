package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@Controller
public class IndexController extends HttpServlet {

    @RequestMapping("/index1")
    @ResponseBody
    public ModelAndView say(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","hello,springboot");
        mv.setViewName("index1");
        return mv;
    }

    @RequestMapping("/upload")
    @ResponseBody
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String uname = request.getParameter("uname");
        System.out.println("姓名："+uname);

        Part part = request.getPart("myfile");
        String fileName = part.getSubmittedFileName();
        System.out.println(fileName);
        InputStream fis = part.getInputStream();

    }
}
