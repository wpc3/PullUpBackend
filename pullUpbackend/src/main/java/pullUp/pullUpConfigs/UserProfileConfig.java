package pullUp.pullUpConfigs;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pullUp.model.UserProfile;
import pullUp.service.UserProfileService;

@Configuration
public class UserProfileConfig {
private UserProfileService service;

public UserProfileConfig(@Autowired UserProfileService repository){
    this.service = repository;
}

@PostConstruct
public void setup(){

}

}
