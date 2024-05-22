package awsreactspring.jong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import awsreactspring.jong.service.CommunityService;
import awsreactspring.jong.repository.CommunityRepository;
import awsreactspring.jong.repository.UserRepository;
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

}
