package com.example.admin;

import com.example.admin.pojo.LoginVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.Valid;

@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AdminApplication.class, args);

		LoginVo  loginVo = new LoginVo();
        loginVo.setMobile("fjkdd");
        System.out.println(loginVo);

	}





}

