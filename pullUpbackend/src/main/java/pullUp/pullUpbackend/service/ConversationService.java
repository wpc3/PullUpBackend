package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.Conversation;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.ConversationRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

import java.util.List;

@Service
public class ConversationService {

    private ConversationRepository conversationRepository;
    private UserProfileRepository userProfileRepository;

    public ConversationService(@Autowired ConversationRepository conversationRepository,
    @Autowired UserProfileRepository userProfileRepository) {
        this.conversationRepository = conversationRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public Conversation createAConversation(Conversation conversation, List<Long> userProfileIds){
        List<UserProfile> userProfiles = (List<UserProfile>) userProfileRepository.findAllById(userProfileIds);

        conversation.setParticipants(userProfiles);

        return conversationRepository.save(conversation);
    }
}
