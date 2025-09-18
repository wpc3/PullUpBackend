package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.Message;
import pullUp.pullUpbackend.repository.MessageRepository;

@Service
public class MessageService {

    private MessageRepository messageRepository;


    public MessageService(@Autowired MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createAMessage(Message message, Long senderId, Long recieverId){



        return  null;
    }
}
