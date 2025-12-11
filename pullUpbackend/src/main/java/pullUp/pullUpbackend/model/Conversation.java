package pullUp.pullUpbackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long convoId;

    private String name;

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "conversation_users",
            joinColumns = @JoinColumn(name = "conversation_id"),
            inverseJoinColumns = @JoinColumn(name = "userProfile_id")
    )
    private List<UserProfile> participants = new ArrayList<>();


    public Conversation(Long convoId, String name) {
        this.convoId = convoId;
        this.name = name;
    }

    public Conversation(){}

    public Long getConvoId() {
        return convoId;
    }

    public void setConvoId(Long convoId) {
        this.convoId = convoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<UserProfile> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserProfile> participants) {
        this.participants = participants;
    }
}
