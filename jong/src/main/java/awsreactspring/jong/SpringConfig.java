package awsreactspring.jong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import awsreactspring.jong.repository.UserRepository;
import awsreactspring.jong.service.UserService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }
}
