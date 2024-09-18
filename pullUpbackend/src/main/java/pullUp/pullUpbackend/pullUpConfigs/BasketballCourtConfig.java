package pullUp.pullUpbackend.pullUpConfigs;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pullUp.pullUpbackend.service.BasketballCourtService;

@Configuration
public class BasketballCourtConfig {
private BasketballCourtService service;

    public BasketballCourtConfig(@Autowired BasketballCourtService service) {
        this.service = service;
    }

    @PostConstruct
    public void setup(){

    }
}
