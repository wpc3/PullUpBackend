package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pullUp.pullUpbackend.model.BasketballCourts;

public interface BasketballCourtsRepository extends CrudRepository<BasketballCourts,Long> {


}
