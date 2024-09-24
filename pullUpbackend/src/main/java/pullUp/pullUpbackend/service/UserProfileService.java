package pullUp.pullUpbackend.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

@Service
public class UserProfileService {
private UserProfileRepository repository;
private BasketballCourtsRepository basketballCourtsRepository;

public UserProfileService(@Autowired UserProfileRepository repository,
                          @Autowired BasketballCourtsRepository basketballCourtsRepository){
    this.repository = repository;
    this.basketballCourtsRepository = basketballCourtsRepository;
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
    return repository.findProfileByUsername(username);
 }

 public UserProfile saveACourtByUserId(Long userId, Long courtId){
 UserProfile userProfile = repository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
 BasketballCourt basketballCourt = basketballCourtsRepository.findById(courtId).orElseThrow(() ->new RuntimeException("court not found") );
 userProfile.addBasketballCourt(basketballCourt);

   return repository.save(userProfile);



 }

    public UserProfile saveACourtByUsername(String username, String courtName){
    UserProfile userProfile = repository.findProfileByUsername(username);
    BasketballCourt basketballCourt = basketballCourtsRepository.findBasketballCourtByCourtName(courtName);
    userProfile.addBasketballCourt(basketballCourt);

    return repository.save(userProfile);
    }

    public UserProfile updateAUserProfile(Long id, UserProfile userProfile){
    UserProfile userProfile1 = repository.findById(id).get();
    userProfile1.setId(userProfile.getId());
    userProfile1.setUsername(userProfile.getUsername());
    userProfile1.setPassword(userProfile.getPassword());



    return repository.save(userProfile1);
    }

}
