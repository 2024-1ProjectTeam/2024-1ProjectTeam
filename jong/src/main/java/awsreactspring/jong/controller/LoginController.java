package awsreactspring.jong.controller;

import java.util.HashMap;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
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
    public String home(Model model, @SessionAttribute(name = "id", required = false) Long id) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

            
        return "new! 메인페이지";
    }
}
