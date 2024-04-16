package awsreactspring.jong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import awsreactspring.jong.domain.CrawlingData;
import awsreactspring.jong.repository.CrawlRepository;
import awsreactspring.jong.repository.UserRepository;
import awsreactspring.jong.service.CrawlingService;
import awsreactspring.jong.service.UserService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final CrawlRepository crawlRepository;
    
    public SpringConfig(UserRepository userRepository, CrawlRepository crawlRepository) {
        this.userRepository = userRepository;
        this.crawlRepository = crawlRepository;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }

    @Bean
    public CrawlingService crawlingService(){
        return new CrawlingService(crawlRepository);
    }
}
