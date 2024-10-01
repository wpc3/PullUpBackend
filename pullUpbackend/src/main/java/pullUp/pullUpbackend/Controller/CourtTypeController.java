package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pullUp.pullUpbackend.repository.CourtTypeRepository;
import pullUp.pullUpbackend.service.CourtTypeService;

@RestController
public class CourtTypeController {
 CourtTypeService courtTypeService;
 CourtTypeRepository courtTypeRepository;
    public CourtTypeController(@Autowired CourtTypeService courtTypeService,
                               @Autowired CourtTypeRepository courtTypeRepository) {
        this.courtTypeService = courtTypeService;
        this.courtTypeRepository = courtTypeRepository;
    }


}
