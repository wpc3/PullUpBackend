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


    @PostMapping("/userProfile/messaging/{senderId}")
    public ResponseEntity<Message> postAMessageToAUser(@PathVariable Long senderId, @RequestBody Message message){
        return new ResponseEntity<>(messageService.createAMessage(message,senderId), HttpStatus.CREATED);
    }

    @PostMapping("/userProfile/messaging/{senderId}/{convoId}")
    public ResponseEntity<Message> postAMessageInAChat(@PathVariable Long senderId, @PathVariable Long convoId, @RequestBody String content){
        return new ResponseEntity<>(messageService.sendMessageInAChat(convoId,senderId,content), HttpStatus.CREATED);
    }
}
