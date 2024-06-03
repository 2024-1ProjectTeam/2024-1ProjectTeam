package awsreactspring.jong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.service.MatchingService;
import awsreactspring.jong.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class matchingcontroller {
    private final MatchingService matchingService;
    private final UserService userService;

    @Autowired
    public matchingcontroller(MatchingService matchingService, UserService userService) {
        this.matchingService = matchingService;
        this.userService = userService;
    }

    //매칭방법
    //1. 환자가 매칭을 누르면 간병인을 추천해서 매칭 
    //2. 간병인이 매칭을 누르면 환자를 추천
    //3. 서로 매칭을 눌러두면 매칭해주는 것(둘 다 누르는 걸 하면 너무 낭비가 아닐지.)

    @PostMapping("api/match")
    public List<SiteUser> matching(@RequestBody SiteUser siteUser) {
      //일단 환자가 매칭을 누르면 간병인을 추천해주는 것으로 개발.
      List<SiteUser> users = userService.findWorker(siteUser.getWorker());

      matchingService.matchingScore(users, siteUser);
      List<SiteUser> Score = matchingService.highScore();

      return Score;
    }
    



}
