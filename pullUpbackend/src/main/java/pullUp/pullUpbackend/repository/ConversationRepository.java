package pullUp.pullUpbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.Conversation;

@Repository
public interface ConversationRepository extends CrudRepository <Conversation, Long> {
}
