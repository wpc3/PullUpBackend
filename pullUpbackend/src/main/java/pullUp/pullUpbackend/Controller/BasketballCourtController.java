package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.service.BasketballCourtService;

@Controller
public class BasketballCourtController {
    private BasketballCourtService service;
    private BasketballCourtsRepository repository;

    public BasketballCourtController(@Autowired BasketballCourtService service,
                                     @Autowired BasketballCourtsRepository repository) {
        this.repository =repository;
        this.service = service;
    }
}
