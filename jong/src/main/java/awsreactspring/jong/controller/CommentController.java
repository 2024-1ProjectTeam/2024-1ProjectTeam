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
import awsreactspring.jong.domain.Comment;
import awsreactspring.jong.service.CommentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }


    @PostMapping("api/Community/Comment/CreateComment") // 댓글 저장(생성)
    public ResponseEntity<Comment> CreateComment(@RequestBody Comment comment) {
        Comment saveComment = commentService.saveComment(comment);
        return new ResponseEntity<>(saveComment,HttpStatus.CREATED);
    }


    // 게시판 id를 통해서 댓글조회
    @GetMapping("api/Community/Comment/{postid}")
    public ResponseEntity<List<Comment>> GetCommentByPostId(@PathVariable Community community){
        List<Comment> comment = commentService.findCommentByPostId(community);
        return ResponseEntity.ok(comment);
    }

    // //유저id를 통해 댓글조회
    // @GetMapping("api/Community/Comment/{userid}")
    // public ResponseEntity<List<Comment>> GetCommentByUserId(@PathVariable Long userid){
    //     List<Comment> comment = commentService.findCommentByUserID(userid);
    //     return ResponseEntity.ok(comment);
    // }

    //댓글 삭제
    // @DeleteMapping("/api/Community/Comment/{commentid}") // 삭제
    // public ResponseEntity<Community> deleteCommunity(@PathVariable Long commentid){
    //     commentService.deleteComment(commentid);
    //     return ResponseEntity.noContent().build();
    // }


}
