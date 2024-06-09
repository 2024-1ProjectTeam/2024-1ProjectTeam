package awsreactspring.jong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import awsreactspring.jong.service.CommunityService;
import awsreactspring.jong.repository.CommunityRepository;
import awsreactspring.jong.repository.CrawlRepository;
import awsreactspring.jong.repository.UserRepository;
import awsreactspring.jong.repository.WorkinglistRepository;
import awsreactspring.jong.service.CrawlingService;
import awsreactspring.jong.service.MatchingService;
import awsreactspring.jong.service.UserService;
import awsreactspring.jong.service.WorkinglistService;
import awsreactspring.jong.repository.CommentRepository;
import awsreactspring.jong.service.CommentService;

@Configuration
public class SpringConfig {
    
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
    private final CommentRepository commentRepository;
    private final WorkinglistRepository workinglistRepository;
    private final CrawlRepository crawlRepository;

    public SpringConfig(UserRepository userRepository, CommunityRepository communityRepository, CommentRepository commentRepository, WorkinglistRepository workinglistRepository, CrawlRepository crawlRepository) {
        this.userRepository = userRepository;
        this.communityRepository = communityRepository;
        this.commentRepository = commentRepository;
        this.workinglistRepository = workinglistRepository;
        this.crawlRepository = crawlRepository;
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

    @Bean
    public MatchingService matchingService(){
        return new MatchingService(userRepository);
    }

    @Bean
    public WorkinglistService workinglistService(){
        return new WorkinglistService(workinglistRepository);
    }

    @Bean
    public CrawlingService crawlingService(){
        return new CrawlingService(crawlRepository);
    }
}
