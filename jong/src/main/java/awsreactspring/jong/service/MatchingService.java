package awsreactspring.jong.service;

import java.util.List;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
public class MatchingService {
    private final UserRepository userRepository;

    public MatchingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //매칭 시스템에서 점수평가를 실행할 예정. 주소를 가장 높은 점수, 그리고 나이대와 성별로 점수를 결정함.
    //유저가 본인의 정보를 제공하면, 거기서 주소와 나이, 성별로 비교해서 점수를 비교한다.

    public void matchingScore(List<SiteUser> users, SiteUser siteUser){
        for(SiteUser user : users){
            locateScore(siteUser, user);
            ageScore(user);
            sexScore(siteUser, user);
        }
    }

    public List<SiteUser> highScore(){
        List<SiteUser> users = userRepository.findByScore(8);
        users.addAll(userRepository.findByScore(7));
        if(userRepository.findByScore(6)!=null){
            users.addAll(userRepository.findByScore(6));
            return users;
        }else{
            users.addAll(userRepository.findByScore(5));
            return users;
        }
    }

    public void locateScore(SiteUser siteUser, SiteUser user){
        String locate = siteUser.getAddress();
        locate = locate.substring(0,locate.lastIndexOf(" "));
        if(user.getAddress().contains(locate)){
            user.setScore(5);
        }else if(user.getAddress().contains(locate.substring(0,locate.lastIndexOf(" ")))){
            user.setScore(3);
        }
    }

    public void ageScore(SiteUser user){
        String birth = user.getBirth();
        String[] birtharr = birth.split("\\.");
        int year = Integer.parseInt(birtharr[0]);

        if(year < 30 | year > 60){
            user.setScore(user.getScore()+1);
        }else{
            user.setScore(user.getScore()+2);
        }
    }

    public void sexScore(SiteUser siteUser, SiteUser user){
        if(siteUser.getSex()==user.getSex()){
            user.setScore(user.getScore()+1);
        }
    }
}
