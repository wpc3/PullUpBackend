package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.BasketballCourt;
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

public UserProfile findUserProfileById(Long id){

    return repository.findById(id).get();
}

    public void delete(UserProfile userProfile){
        repository.delete(userProfile);
    }

 public UserProfile findUserProfileByUserName(String username){
    return repository.findSavedCourtsByUsername(username);
 }

 public void saveACourtByUsername(UserProfile user, String courName){
    BasketballCourt savedCourt = new BasketballCourt();
    savedCourt.setCourt_name(courName);

    user.getBasketballCourts().add(savedCourt);
 }



}
