package pullUp.pullUpbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourtType {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private Boolean indoor = false;

    public CourtType() {
    }

    public CourtType(Long id, Boolean indoor){
        this.id = id;
        this.indoor = indoor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }
}
