package awsreactspring.jong.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class pagecontroller {

    private final UserService userService;

    @Autowired
    public pagecontroller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/test")
    public String hello() {
        return "테스트아님니다.";
    }

    @ResponseBody
    @PostMapping("/api/join")
    public String UserJoin(@RequestBody SiteUser siteUser) {
        userService.join(siteUser);
        return "데이터 받기 성공";
    }

    @PostMapping("/api/login")
    public String UserLogin(@RequestBody SiteUser siteUser) {
        System.out.println(siteUser);        
        System.out.println(siteUser.getName());
        System.out.println(siteUser.getEmail());
        return "받았음.";
    }
    

    @GetMapping("/")
    public String home() {
        return "new! 메인페이지";
    }
}
