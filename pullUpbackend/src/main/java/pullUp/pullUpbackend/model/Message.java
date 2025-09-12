package pullUp.pullUpbackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime sentAt;

    //ensures JPA automatically fills sentAt just before inserting into the database.
    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }

    public Message() {
    }

    public Message(long messageId, String content, LocalDateTime sentAt) {
        this.messageId = messageId;
        this.content = content;
        this.sentAt = sentAt;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
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
}