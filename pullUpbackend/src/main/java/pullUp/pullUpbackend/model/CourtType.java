package pullUp.pullUpbackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CourtType {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private Boolean indoor = false;

@OneToMany(mappedBy = "courtType")
private Set<BasketballCourt> basketballCourts = new HashSet<>();


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
