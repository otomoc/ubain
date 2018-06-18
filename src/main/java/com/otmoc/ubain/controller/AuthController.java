package com.otmoc.ubain.controller;

import com.otmoc.ubain.model.LoginUser;
import com.otmoc.ubain.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/auth/login")
    @ResponseBody public Object loginOn(@RequestParam String userName, @RequestParam String password) {
        System.out.println("userName= " + userName);
        System.out.println("password= " + password);

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, null);
        token.setRememberMe(true);

        SecurityUtils.getSubject().login(token);

        return token;
    }

}
