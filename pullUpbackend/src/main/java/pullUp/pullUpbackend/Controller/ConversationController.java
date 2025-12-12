package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/conversations/{userProfileId}")
    public ResponseEntity<List<Conversation>> getAllConversationByUserProfile(@PathVariable Long userProfileId){
        return new ResponseEntity<>(conversationService.findConversationByUserProfile(userProfileId),HttpStatus.OK);
    }
}
