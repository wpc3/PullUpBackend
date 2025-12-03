package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.Message;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query(value = "select m.content from messages m join conversation_users c on c.sender_id = m.convo_id where c.reciever_id = ?", nativeQuery = true)
    List<String> readMessagesByUserId(Long userId);

}
