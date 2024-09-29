package pullUp.pullUpbackend.pullUpConfigs;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import pullUp.pullUpbackend.service.CourtTypeService;

@Configuration
public class CourtTypeConfig {
CourtTypeService courtTypeService;

    public CourtTypeConfig(CourtTypeService courtTypeService) {
        this.courtTypeService = courtTypeService;
    }

    @PostConstruct
    public void setUp(){}
}
