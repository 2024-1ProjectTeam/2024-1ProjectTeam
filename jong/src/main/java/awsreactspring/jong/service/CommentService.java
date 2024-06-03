package awsreactspring.jong.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import jakarta.transaction.Transactional;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.domain.Comment;
import awsreactspring.jong.domain.Community;
import awsreactspring.jong.repository.CommentRepository;
import awsreactspring.jong.repository.CommunityRepository;

@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment){ //댓글 저장(등록)
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentByPostId(Community community) { // 게시판 아이디를 통해 댓글 조회 
        List<Comment> comments = commentRepository.findAllByCommunity(community);
        if(comments.isEmpty()){
            throw new NoSuchElementException("해당 게시판의 댓글을  찾을수 없음.");
        }
        return comments;
    }

    public List<Comment> findCommentByUserID(SiteUser siteuser){ //유저 아이디를 통해 댓글 조회 이거 데이터베이스 연동해야함.. 찾아서 manytoOne으로 하긴했는데 될지 모름....
        List<Comment> comments = commentRepository.findAllBySiteuser(siteuser);
        if(comments.isEmpty()){
            throw new NoSuchElementException("해당 유저의 댓글을 찾을수 없음.");
        }
        return comments;
    }
    
    // public void deleteCommunity(Long postid) {    // 게시글 아이디를 이용하여,삭제
    //     Optional<Community> existingCommunityOptional = communityRepository.findByPostid(postid);
    //     Community existingCommunity = existingCommunityOptional.orElseThrow(() -> new NoSuchElementException("해당 ID의 게시글이 존재하지 않습니다."));
        
    //     communityRepository.delete(existingCommunity);;
    // }

    // public Community findByCommentid(Long commentid){  // 게시글 id를 통한 조회  ??
    //     return commentRepository.findByCommentid(commentid).orElse(null);
        
    // }



    public void deleteComment(Long commentid) {    // 댓글을 조회하고 삭제. ?? 뭔가 이상한 내가 뭘 생각하고 만든거지
        List<Comment> existingComments = commentRepository.findByCommentid(commentid);
        if(existingComments.isEmpty()){
            throw new NoSuchElementException("해당 댓글을 찾을수 없음.");
        }
        commentRepository.deleteById(commentid);
    }

    
}
