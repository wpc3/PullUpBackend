package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.Message;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.MessageRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private UserProfileRepository userProfileRepository;


    public MessageService(@Autowired MessageRepository messageRepository,
                          @Autowired UserProfileRepository userProfileRepository) {
        this.messageRepository = messageRepository;
        this.userProfileRepository = userProfileRepository;
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
}
