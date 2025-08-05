package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.customException.UnauthorizedException;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

import java.util.List;
import java.util.Optional;

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

public UserProfile createAnAccount(UserProfile userProfile){

    String username = userProfile.getUsername();
    String password = userProfile.getPassword();

    if (username == null || username.trim().isEmpty()) {
        throw new IllegalArgumentException("Username must not be blank.");
    }

    if (password == null || password.length() < 7) {
        throw new IllegalArgumentException("Password must be at least 7 characters.");
    }

    if(repository.existsByUsername(username)){
        throw new IllegalArgumentException("usernameAlreadyExists");
    }

    return repository.save(userProfile);

}


public UserProfile userLogin(UserProfile userProfile){

    String username = userProfile.getUsername();
    String password = userProfile.getPassword();

    if (username == null || password == null) {

        throw new IllegalArgumentException("Username must not be blank.");
    }

    return Optional.ofNullable( repository.findProfileByUsername(username))
            .filter(acc -> acc.getPassword().equals(password))
            .orElseThrow(() -> new UnauthorizedException("Invalid username or password"));

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

 public UserProfile addAFriend(Long userId, Long friendId){

    UserProfile userProfile = repository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
    UserProfile userProfile1 = repository.findById(friendId).orElseThrow(() -> new RuntimeException("user not found"));

    userProfile.addUserProfile(userProfile1);
    userProfile1.addUserProfile(userProfile);


    repository.save(userProfile1);

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
    userProfile1.setUserRank(userProfile.getUserRank());

    return repository.save(userProfile1);
    }

    public List<String> findAllFriendsByUserId(Long id){

    return repository.findFriendsByUserId(id);

    }



}
