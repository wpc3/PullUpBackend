package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.service.BasketballCourtService;

import java.util.List;

@RestController
public class BasketballCourtController {
    private BasketballCourtService service;
    private BasketballCourtsRepository repository;

    public BasketballCourtController(@Autowired BasketballCourtService service,
                                     @Autowired BasketballCourtsRepository repository) {
        this.repository =repository;
        this.service = service;
    }

    @GetMapping("/bballCourts")
    public List<BasketballCourt> listAllCourts(){
        return service.findAllBasketballCourts();
    }

    @GetMapping("/basketballCourt/{courtName}")
    public ResponseEntity<BasketballCourt> findCourtbyName(@PathVariable("courtName") String courtName){
        return new ResponseEntity<>(service.findBallCourtByName(courtName), HttpStatus.OK);
    }

    @PostMapping("/basketballCourt")
    public ResponseEntity<BasketballCourt> postCourt(@RequestBody BasketballCourt basketballCourt){
        return new ResponseEntity<>(service.createABasketballCourt(basketballCourt), HttpStatus.CREATED);
    }


}
