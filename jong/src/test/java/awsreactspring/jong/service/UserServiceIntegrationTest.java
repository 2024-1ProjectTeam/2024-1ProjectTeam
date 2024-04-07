package awsreactspring.jong.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.repository.UserRepository;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

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
}
