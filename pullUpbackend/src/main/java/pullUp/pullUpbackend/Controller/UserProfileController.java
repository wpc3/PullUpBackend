package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        System.out.println("User: " + id);
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

        userProfile = service.saveACourtByUserId(userId,courtId);



     return ResponseEntity.ok(userProfile)  ;
    }

    @PutMapping("/userProfile/user/{username}/ballCourt/{courtName}")
    public ResponseEntity<UserProfile> addCourtsToUserProfileByUsername(
            @PathVariable("username") String username,
            @PathVariable("courtName") String courtName,
            @RequestBody UserProfile userProfile

    ){

        userProfile = service.saveACourtByUsername(username,courtName);



        return ResponseEntity.ok(userProfile)  ;
    }

    @PutMapping("/userProfile/{id}")
    public ResponseEntity<UserProfile> updateUserProfiles(
            @PathVariable("id") Long id,
            @RequestBody UserProfile userProfile
    ){
        return new ResponseEntity<>(service.updateAUserProfile(id, userProfile),HttpStatus.ACCEPTED);
    }


}
