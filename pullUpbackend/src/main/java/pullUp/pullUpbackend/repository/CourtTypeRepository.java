package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.CourtType;

@Repository
public interface CourtTypeRepository extends CrudRepository<CourtType,Long> {


}
