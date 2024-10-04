package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pullUp.pullUpbackend.model.CourtType;

public interface CourtTypeRepository extends CrudRepository<CourtType,Long> {


}
