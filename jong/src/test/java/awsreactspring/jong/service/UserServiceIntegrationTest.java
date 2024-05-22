package awsreactspring.jong.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.domain.Comment;
import awsreactspring.jong.domain.Community;
import awsreactspring.jong.repository.*;
import awsreactspring.jong.service.*;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Autowired CommunityService communityService;
    @Autowired CommunityRepository communityRepository;

    @Autowired CommentService commentService;
    @Autowired CommentRepository commentRepository;

    @Test
    @Commit
    void 회원가입() throws Exception {
        //given
        SiteUser user = new SiteUser();
        user.setEmail("jong@naver.com");
        user.setPassword("1234");
        user.setName("jong");
        user.setPhone("010-1234-1234");
        user.setBirth("2000.04.29");
        user.setAddress("충주시");               

        //when
        String Check = userService.join(user);
        
        //then
        System.out.println(Check);
    }

    @Test
    void 로그인() throws Exception {
        //given
        SiteUser user = new SiteUser();
        user.setEmail("jong@naver.com");
        user.setPassword("1234");
        user.setName("jong");
        user.setPhone("010-1234-1234");
        user.setBirth("2000.04.29");
        user.setAddress("충주시");  

        SiteUser coruser = new SiteUser();
        coruser.setEmail("jong@naver.com");
        coruser.setPassword("1234");

        SiteUser emailuser = new SiteUser();
        emailuser.setEmail("j@naver.com");
        emailuser.setPassword("1234");

        SiteUser passuser = new SiteUser();
        passuser.setEmail("jong@naver.com");
        passuser.setPassword("12345");


        //when
        String Check = userService.join(user);

        //then
        userService.login(coruser);

        IllegalStateException e = assertThrows(IllegalStateException.class,
            () -> userService.login(emailuser));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이메일이 없습니다.");

        IllegalStateException er = assertThrows(IllegalStateException.class,
            () -> userService.login(passuser));//예외가 발생해야 한다.
        assertThat(er.getMessage()).isEqualTo("비밀번호가 일치 하지 않음.");


    }
    @Test
    void 회원정보제공() throws Exception{
        //given

        SiteUser user = new SiteUser();
        user.setEmail("jong@naver.com");
        user.setPassword("1234");
        user.setName("jong");
        user.setPhone("010-1234-1234");
        user.setBirth("2000.04.29");
        user.setAddress("충주시"); 

        //when
        String Check = userService.join(user);

        SiteUser getUser = userService.finduser(user);
        System.out.println(getUser.getAddress());        
        System.out.println(getUser.getEmail());


    }
    @Test
    @Commit
    void 정보수정() throws Exception{
        SiteUser user = new SiteUser();
        user.setEmail("jong@naver.com");
        user.setPassword("12345");
        user.setName("jong");
        user.setPhone("010-1234-1234");
        user.setBirth("2000.03.29");
        user.setAddress("대한민국 청주시"); 

        userService.changeUser(user);
    }

    @Test
    @Commit
    void 게시판생성() throws Exception{
        Community community = new Community();
        community.setTitle("게시판");
        community.setContent("게시판 생성됫지롱");
        community.setpostid(5L);

        //when
        Community saveCommunity = communityService.saveCommunity(community);
        
        //then
        System.out.println(saveCommunity);
    }

    
    // @Test
    // void 게시판수정() throws Exception{
    //     Community existingCommunity = new Community();
    //     //given
    //     //Community existingCommunity = findByPostid(postid);
    //     existingCommunity.setuserid(4L);
    //     existingCommunity.setTitle("게시판 수정");
    //     existingCommunity.setContent("수정입니다");

    //     //when
    //     //Community changeCommunity = communityService.changeCommunity(Long postid, Community );
    //     communityService.changeCommunity(existingCommunity.getuserid(), existingCommunity);

        
    //     //communityService.changeCommunity(Long postid, Community changedCommunity);
        
    // }
    @Test
    @Commit
    void 게시판수정() throws Exception{
    //given
        Community existingCommunity = new Community();
        existingCommunity.setpostid(5L); // 게시물의 postid를 설정
        existingCommunity.setTitle("게시판 수정ㅎㅎㅎㅎㅎㅎㅎㅎ");
        existingCommunity.setContent("수정입니다ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");

    //when
        communityService.changeCommunity(existingCommunity.getpostid(), existingCommunity);
}


    // public void deleteCommunity(Long postid) {    // 게시글 아이디를 이용하여,삭제
    //     Optional<Community> existingCommunityOptional = communityRepository.findByPostId(postid);
    //     Community existingCommunity = existingCommunityOptional.orElseThrow(() -> new NoSuchElementException("해당 ID의 게시글이 존재하지 않습니다."));
        
    //     communityRepository.delete(existingCommunity);;
    // }
    

    @Test
    @Commit
    void 게시판삭제() throws Exception{

        //given
        Community existingCommunity = new Community();
        existingCommunity.setpostid(5L);
        

        //when
        communityService.deleteCommunity(5L);

        //then
       
    }

    @Test
    @Commit
    void 게시판제목으로조회() throws Exception{
        
        //given
        String title = "게시판";
    
        //when
        List<Community> communities = communityRepository.findByTitleContaining(title);

        //then
        if(communities.isEmpty()){
            throw new IllegalStateException("해당하는 게시판이 존재하지 않음");
        }else{
            
            System.out.println(communities);
        }


    }

    @Test
    void 게시판내용으로조회() throws Exception{
        
        //given
        String content = "게시판";
    
        //when
        List<Community> communities = communityRepository.findByTitleContaining(content);

        //then
        if(communities.isEmpty()){
            throw new IllegalStateException("해당하는 게시판이 존재하지 않음");
        }else{
            
            System.out.println(communities);
        }


    }

    @Test
    void 전체게시판조회() throws Exception{

        List<Community> communities = communityRepository.findAll();


        System.out.println(communities);

    }

    @Test
    @Commit
    void 댓글생성() throws Exception{
        Comment comment = new Comment();

        comment.setContent("아니 왜 안돼는거야!!!!!!!!!");

        Comment saveComment = commentService.saveComment(comment);

        System.out.println(saveComment);

    }

    @Test
    @Commit
    void 댓글삭제() throws Exception{

        Comment existingComment = new Comment();


        commentService.deleteComment(1L);
    }



    
}

