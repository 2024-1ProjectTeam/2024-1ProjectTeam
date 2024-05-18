package awsreactspring.jong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import awsreactspring.jong.domain.Comment;

public interface SpringDataJpaCommentRepository extends JpaRepository<Comment,Long>{

    Comment save(Comment comment); //저장

    List<Comment> findByPostId(Long postid); // 게시판 아이디를 이용하여 댓글 조회

    List<Comment> findByUserId(Long userid); // 유저 아이디를 이용하여 댓글 조회

    void deleteById(Long commentid); // 댓글 삭제
    
} 