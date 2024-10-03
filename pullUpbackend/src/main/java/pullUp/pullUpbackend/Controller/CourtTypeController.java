package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pullUp.pullUpbackend.model.CourtType;
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

 @PutMapping("/courtType/{courtTypeId}/basketballCourt/{basketballCourtId}")
 public ResponseEntity<CourtType> postBasketballCourtToCourtType(@PathVariable("courtTypeId") Long courtTypeId,
                                                                 @PathVariable("basketballCourtId") Long basketballCourtId,
                                                                 @RequestBody CourtType courtType){
        courtType = courtTypeService.saveABasketBallCourtById(courtTypeId,basketballCourtId);

        return ResponseEntity.ok(courtType);
 }
}
