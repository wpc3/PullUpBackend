package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pullUp.pullUpbackend.model.BasketballCourt;

public interface BasketballCourtsRepository extends CrudRepository<BasketballCourt,Long> {

    @Query("SELECT U FROM BasketballCourt U WHERE U.court_name = ?1")
   BasketballCourt findBasketballCourtByCourtName(String courtName);

}
