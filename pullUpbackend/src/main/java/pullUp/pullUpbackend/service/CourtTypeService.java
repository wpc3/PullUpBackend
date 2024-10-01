package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.repository.CourtTypeRepository;
@Service
public class CourtTypeService {

    CourtTypeRepository courtTypeRepository;

    public CourtTypeService(@Autowired CourtTypeRepository courtTypeRepository) {
        this.courtTypeRepository = courtTypeRepository;
    }


}
