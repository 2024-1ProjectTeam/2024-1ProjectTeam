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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;




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
    public String UserLogin(@RequestBody SiteUser siteUser, HttpServletRequest request) {
        if(userService.login(siteUser)){
            HttpSession session = request.getSession();
            siteUser = userService.finduser(siteUser);
            session.setAttribute("username", siteUser.getName());
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/api/logout")
    public String UserLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);        
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/api/main")
    public String main(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null){
            Object obj = session.getAttribute("username");
            String name = obj != null ? obj.toString() : null;
            return name;
        }
        return "fail";
    }
    


    
    
    
}
