package pullUp.pullUpbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
