package pullUp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pullUp.model.UserProfile;
import pullUp.repository.UserProfileRepository;

@Service
public class UserProfileService {
private UserProfileRepository repository;

public UserProfileService(@Autowired UserProfileRepository repository){
    this.repository = repository;
}

public UserProfile create(UserProfile userProfileToPersist){
    return repository.save(userProfileToPersist);


}




}
