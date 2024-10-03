package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.BasketballCourt;
import pullUp.pullUpbackend.model.CourtType;
import pullUp.pullUpbackend.repository.BasketballCourtsRepository;
import pullUp.pullUpbackend.repository.CourtTypeRepository;
@Service
public class CourtTypeService {

    CourtTypeRepository courtTypeRepository;
   BasketballCourtsRepository basketballCourtsRepository;

    public CourtTypeService(@Autowired CourtTypeRepository courtTypeRepository,
                            @Autowired BasketballCourtsRepository basketballCourtsRepository) {
        this.courtTypeRepository = courtTypeRepository;
        this.basketballCourtsRepository = basketballCourtsRepository;
    }

    public CourtType saveABasketBallCourtById(Long courtTypeId, Long basketballId){
        CourtType courtType = courtTypeRepository.findById(courtTypeId).orElseThrow(() -> new RuntimeException("court type id not found"));
        BasketballCourt basketballCourt = basketballCourtsRepository.findById(basketballId).orElseThrow(() -> new RuntimeException("court id not found"));
        courtType.addBasketballCourt(basketballCourt);

        return courtTypeRepository.save(courtType);
    }

}
