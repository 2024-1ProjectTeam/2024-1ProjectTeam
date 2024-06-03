package awsreactspring.jong.repository;

import java.util.List;
import java.util.Optional;

import awsreactspring.jong.domain.Community;
import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.domain.Comment;

public interface CommentRepository {

    Comment save(Comment comment); //저장
    
    List<Comment> findByCommentid(Long commentid);

    List<Comment> findAllByCommunity(Community community); // 게시판 아이디를 이용하여 댓글 조회

    List<Comment> findAllBySiteuser(SiteUser siteuser); // 유저 아이디를 이용하여 댓글 조회

    void deleteById(Long commentid); // 댓글 삭제
    
    
} 
