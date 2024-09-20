package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;
import pullUp.pullUpbackend.service.UserProfileService;

import java.util.List;

@RestController
public class UserProfileController {
  private final UserProfileService service;
  private final UserProfileRepository repository;
  private final BasketballCourtsRepository basketballCourtsRepository;

    public UserProfileController(@Autowired UserProfileService service,
                                 @Autowired UserProfileRepository repository,
                                 @Autowired BasketballCourtsRepository basketballCourtsRepository) {
        this.service = service;
        this.repository = repository;
        this.basketballCourtsRepository = basketballCourtsRepository;
    }

    @GetMapping("/userProfile/{id}")
    public ResponseEntity<UserProfile> showUserProfileById(@PathVariable("id") Long id){
        System.out.println(service.findUserProfileById(id));
        return new ResponseEntity<>(service.findUserProfileById(id), HttpStatus.OK);
    }

    @GetMapping("/userProfiles")
    public List<UserProfile> findAllUserProfiles(){
        return (List<UserProfile>) repository.findAll();
    }

    @GetMapping("/userProfile/username/{username}")
    public ResponseEntity<UserProfile> showUserProfileByUsername(@PathVariable("username") String username){

        return new ResponseEntity<>(service.findUserProfileByUserName(username), HttpStatus.OK);
    }

    @PostMapping("/userProfile")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile){
        return new ResponseEntity<>(service.create(userProfile), HttpStatus.CREATED);
    }

    @DeleteMapping("/userProfile/delete/{id}")
    public ResponseEntity<Void> removeUserProfile(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/userProfile/username/{userId}/ballCourt/{courtId}")
    public ResponseEntity<UserProfile> addCourtsToUserProfile(
            @PathVariable("userId") Long userId,
            @PathVariable("courtId") Long courtId,
            @RequestBody UserProfile userProfile

            ){

        userProfile = service.saveACourtByUsername(userId,courtId);

        System.out.println("username " + userId);
        System.out.println("courtName " + courtId);
//        System.out.println("user profile: " + userProfile);

     return ResponseEntity.ok(userProfile)  ;
    }
}
