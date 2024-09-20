package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

import java.util.List;
@Service
public class BasketballCourtService {
    private BasketballCourtsRepository repository;
    private UserProfileRepository userProfileRepository;
    public BasketballCourtService(@Autowired BasketballCourtsRepository repository,
                                  @Autowired UserProfileRepository userProfileRepository) {
        this.repository = repository;
        this.userProfileRepository = userProfileRepository;
    }

    public List<BasketballCourt> findAllBasketballCourts(){
        return (List<BasketballCourt>) repository.findAll();
    }

    public List<BasketballCourt> findAllCourtsSavedByUser(String username){
        return null;
    }

    public BasketballCourt findBallCourtByName(String courtName){
        return repository.findBasketballCourtByCourtName(courtName);
    }

}
