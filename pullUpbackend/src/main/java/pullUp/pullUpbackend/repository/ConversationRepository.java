package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.Conversation;

import java.util.List;

@Repository
public interface ConversationRepository extends CrudRepository <Conversation, Long> {

    @Query(value = " select * from conversation c join conversation_users cu on c.convo_id=cu.conversation_id where cu.user_profile_id = ?", nativeQuery = true)
    List<Conversation> findAllCoversationsByUserProfileId(Long userId);
}
