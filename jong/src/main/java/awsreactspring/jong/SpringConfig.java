package awsreactspring.jong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import awsreactspring.jong.service.CommunityService;
import awsreactspring.jong.repository.CommunityRepository;
import awsreactspring.jong.repository.UserRepository;
<<<<<<< HEAD
import awsreactspring.jong.service.CrawlingService;
import awsreactspring.jong.service.MatchingService;
=======
>>>>>>> 2ae52a74001347dfa8dbe1bec8e6fce254b0db56
import awsreactspring.jong.service.UserService;
import awsreactspring.jong.repository.CommentRepository;
import awsreactspring.jong.service.CommentService;

@Configuration
public class SpringConfig {
    
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
    private final CommentRepository commentRepository;

    public SpringConfig(UserRepository userRepository, CommunityRepository communityRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.communityRepository = communityRepository;
        this.commentRepository = commentRepository;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }
        
    @Bean
    public CommunityService communityService(){
        return new CommunityService(communityRepository);
    }

    @Bean
    public CommentService commentService(){
        return new CommentService(commentRepository);
    }

<<<<<<< HEAD
    @Bean
    public MatchingService matchingService(){
        return new MatchingService(userRepository);
    }
=======
>>>>>>> 2ae52a74001347dfa8dbe1bec8e6fce254b0db56
}
