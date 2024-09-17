package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.service.UserProfileService;

@RestController
public class UserProfileController {
  private final UserProfileService service;

    public UserProfileController(@Autowired UserProfileService service) {
        this.service = service;
    }

    @GetMapping("/userProfile/{id}")
    public ResponseEntity<UserProfile> showUserProfileById(@PathVariable("id") Long id){

        return new ResponseEntity<>(service.findUserProfileById(id), HttpStatus.OK);
    }

    @PostMapping("/userProfile/")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile){
        return new ResponseEntity<>(service.create(userProfile), HttpStatus.CREATED);
    }
}
