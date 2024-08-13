package com.tutiendaonline.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value = "login")
    public String Login(){
        return "Login";
    }

    @PostMapping(value = "register")
    public String Register(){
        return "Register";
    }
}
