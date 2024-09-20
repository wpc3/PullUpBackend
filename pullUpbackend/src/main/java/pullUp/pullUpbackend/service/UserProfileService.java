package pullUp.pullUpbackend.service;

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

 public void saveACourtByUsername(UserProfile user, String courName){
    BasketballCourt basketballCourt = basketballCourtsRepository.findBasketballCourtByCourtName(courName);
    basketballCourt.setCourt_name(courName);
    user.addBasketballCourt(basketballCourt);
 }



}
