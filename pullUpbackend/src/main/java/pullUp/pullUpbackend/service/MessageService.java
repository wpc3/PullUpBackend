package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.Conversation;
import pullUp.pullUpbackend.model.Message;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.ConversationRepository;
import pullUp.pullUpbackend.repository.MessageRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

import java.nio.channels.Channel;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private UserProfileRepository userProfileRepository;
    private ConversationRepository conversationRepository;


    public MessageService(@Autowired MessageRepository messageRepository,
                          @Autowired UserProfileRepository userProfileRepository,
                          @Autowired ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.userProfileRepository = userProfileRepository;
        this.conversationRepository = conversationRepository;
    }

    public Message createAMessage(Message message, Long senderId){

        UserProfile sender = userProfileRepository.findById(senderId).orElseThrow(() -> new RuntimeException("user not found"));
//        UserProfile receiver = userProfileRepository.findById(recieverId).orElseThrow(() -> new RuntimeException("user not found"));

//        message.setReceiver(receiver);
        message.setSender(sender);
        message.setMessageId(null);
        message.setSentAt(null);

        sender.getMessages().add(message);
//        receiver.getMessages().add(message);

        return  messageRepository.save(message);
    }



    public Message sendMessageInAChat(Long convoId, Long senderId, String content) {
        UserProfile userProfile = userProfileRepository.findById(senderId).orElseThrow((() -> new RuntimeException("user not found")));
        Conversation conversation = conversationRepository.findById(convoId).orElseThrow((() -> new RuntimeException("conversation ID not found")));

        Message message = new Message();
        message.setContent(content);
        message.setSender(userProfile);
        message.setConversation(conversation);

        return messageRepository.save(message);
    }
    public List<String> getMessagesByUserId(Long userId){
        return messageRepository.readMessagesByUserId(userId);
        }

}
