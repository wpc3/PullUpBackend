package pullUp.pullUpbackend.pullUpConfigs;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.service.UserProfileService;

@Configuration
public class UserProfileConfig {
private UserProfileService service;

public UserProfileConfig(@Autowired UserProfileService repository){
    this.service = repository;
}

@PostConstruct
public void setup(){
service.create(new UserProfile(1L,"wpc3","123","123","456"));
}

}
