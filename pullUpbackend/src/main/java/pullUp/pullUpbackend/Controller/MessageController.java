package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pullUp.pullUpbackend.model.Message;
import pullUp.pullUpbackend.service.MessageService;

@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(@Autowired MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping("/userProfile/messaging/{senderId}/{receiverId}")
    public ResponseEntity<Message> postAMessageToAUser(@PathVariable Long senderId, @PathVariable Long receiverId, @RequestBody Message message){
        return new ResponseEntity<>(messageService.createAMessage(message,senderId,receiverId), HttpStatus.CREATED);
    }
}
