package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.UserProfileRepository;

@Service
public class UserProfileService {
private UserProfileRepository repository;

public UserProfileService(@Autowired UserProfileRepository repository){
    this.repository = repository;
}

public UserProfile create(UserProfile userProfileToPersist){
    return repository.save(userProfileToPersist);



}

    public void delete(UserProfile userProfile){
        repository.delete(userProfile);
    }


}
