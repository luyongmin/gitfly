package com.example.admin.controller;

import com.example.admin.pojo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * @author: lu.yongmin
 * @date: 2019/1/31 14:50
 * @description:
 */
@Controller
@RequestMapping("/admin/login")
public class LoginController {


    @PostMapping("/login")
    @ResponseBody
    public String login(@Valid LoginVo loginVo){
        System.out.println("loginVo:"+loginVo);
        return "success";
    }

}
