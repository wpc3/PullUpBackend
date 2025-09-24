package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.repository.ConversationRepository;

@Service
public class ConversationService {

    private ConversationRepository conversationRepository;

    public ConversationService(@Autowired ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }
}
