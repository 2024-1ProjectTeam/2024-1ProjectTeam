package awsreactspring.jong.controller;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import awsreactspring.jong.domain.Community;
import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.service.CommunityService;
import awsreactspring.jong.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService){
        this.communityService = communityService;
    }
    
    @GetMapping("/api/Community") // 커뮤니티게시판(리스트) 전체
    public List<Community> communitylist(){
        return communityService.findAll();
    }
    
    
    @PostMapping("/api/Community/Post") //생성
    public ResponseEntity<Community> postCommunity(@RequestBody Community community){
        Community saveCommunity = communityService.saveCommunity(community);
        return new ResponseEntity<>(saveCommunity,HttpStatus.CREATED);
    }
    
    @GetMapping("/api/Community/{postid}") // postid로 조회
    public ResponseEntity<Community> detailCommunity(@PathVariable Long postid){
        Community community = communityService.findByPostId(postid);
        return ResponseEntity.ok(community);
    }
    
    @GetMapping("/api/Community/{userid}") // userid로 조회
    public ResponseEntity<Community> GetByUserIdCommunity(@PathVariable Long userid){
        Community community = communityService.findCommunityByUserId(userid);
        return ResponseEntity.ok(community);
    }
    
    @GetMapping("/api/Community/{title}") // title로 조회
    public ResponseEntity<Community> GetByTitleCommunity(@PathVariable String title){
        Community community = communityService.findCommunityByTitle(title);
        return ResponseEntity.ok(community);
    }
    
    @GetMapping("/api/Community/{content}") // content로 조회
    public ResponseEntity<Community> GetByContentCommunity(@PathVariable String content){
        Community community = communityService.findCommunityByTitle(content);
        return ResponseEntity.ok(community);
    }

    @PutMapping("/api/Community/{postid}")  //수정
    public ResponseEntity<Community> updateCommunity(@PathVariable Long postid, @RequestBody Community community) {
        communityService.changeCommunity(postid, community);
        return ResponseEntity.ok(community);
    }

    @DeleteMapping("/api/Community/{postid}") // 삭제
    public ResponseEntity<Community> deleteCommunity(@PathVariable Long postid){
        communityService.deleteCommunity(postid);
        return ResponseEntity.noContent().build();
    }

    /* 
    @GetMapping("/api/Community/{id}") // postid로 조회
    public ResponseEntity<Community> detailCommunity(@PathVariable Long postid){
        Community community = communityService.findByPostId(postid);
        return ResponseEntity.ok(community);
    }
    */
}
