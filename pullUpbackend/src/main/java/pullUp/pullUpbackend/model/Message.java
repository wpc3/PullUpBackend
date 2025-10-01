package pullUp.pullUpbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime sentAt;

    //ensures JPA automatically fills sentAt just before inserting into the database.
    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }

//    @ManyToMany( mappedBy = "messages")
//    @JsonIgnore
//    private Set<UserProfile> userProfiles = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="sender_id")
    private UserProfile sender;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "receiver_id")
//    private UserProfile receiver;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "convoId")
    private Conversation conversation;


    public Message() {
    }

    public Message(Long messageId, String content, LocalDateTime sentAt) {
        this.messageId = messageId;
        this.content = content;
        this.sentAt = sentAt;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    //    public UserProfile getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(UserProfile receiver) {
//        this.receiver = receiver;
//    }

    //    public Set<UserProfile> getUserProfiles() {
//        return userProfiles;
//    }
//
//    public void setUserProfiles(Set<UserProfile> userProfiles) {
//        this.userProfiles = userProfiles;
//    }

    //    public UserProfile getUser() {
//        return user;
//    }
//
//    public void setUser(UserProfile user) {
//        this.user = user;
//    }
}