package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pullUp.pullUpbackend.model.BasketballCourt;

import java.util.List;

public interface BasketballCourtsRepository extends CrudRepository<BasketballCourt,Long> {

    @Query("SELECT U FROM BasketballCourt U WHERE U.court_name = ?1")
   BasketballCourt findBasketballCourtByCourtName(String courtName);

    @Query(value = "SELECT b.* FROM basketball_court b WHERE b.court_type_id = 1", nativeQuery = true)
    List<BasketballCourt> findAllOutdoorCourtsById();

    @Query(value = "SELECT b.* FROM basketball_court b WHERE b.court_type_id = 2", nativeQuery = true)
    List<BasketballCourt> findAllIndoorCourtsById();

}
