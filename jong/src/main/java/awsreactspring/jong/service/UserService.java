package awsreactspring.jong.service;

import java.util.Optional;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원가입
    public String join(SiteUser user){
        try{
            //중복확인
            validateDuplicatiteUser(user);
            userRepository.save(user);
            return "회원 가입 완료";
        }
        catch(IllegalStateException e){
            return e.getMessage();
        }
    }

    public void login(SiteUser user){
        Optional<SiteUser> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("이메일이 없습니다.");
        }

        SiteUser findUser = optionalUser.get();
        if(!findUser.getPassword().equals(user.getPassword())){
            throw new IllegalStateException("비밀번호가 일치 하지 않음.");
        }

    }

    public SiteUser finduser(SiteUser user){
        Optional<SiteUser> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("잘못된 요청입니다.");
        }else{
            return optionalUser.get();
        }
    }

    public void changeUser(SiteUser user){
        SiteUser getUser = finduser(user);

        getUser.setAddress(user.getAddress());
        getUser.setBirth(user.getBirth());
        getUser.setName(user.getName());
        getUser.setPassword(user.getPassword());
    }

    public void validateDuplicatiteUser(SiteUser user){
        userRepository.findByEmail(user.getEmail())
            .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 이메일입니다.");});
        userRepository.findByPhone(user.getPhone())
            .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 전화번호입니다.");});
    }

}
