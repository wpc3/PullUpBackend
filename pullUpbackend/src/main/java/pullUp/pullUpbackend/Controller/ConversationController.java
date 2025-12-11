package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pullUp.pullUpbackend.model.Conversation;
import pullUp.pullUpbackend.service.ConversationService;

import java.util.List;

@RestController
public class ConversationController {


    ConversationService conversationService;

    public ConversationController(@Autowired ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/conversation/{userIds}")
    public ResponseEntity<Conversation> postAconversation(@RequestBody Conversation conversation,@PathVariable List<Long> userIds){
    return new ResponseEntity<>(conversationService.createAConversation(conversation,userIds), HttpStatus.CREATED);
    }


}
