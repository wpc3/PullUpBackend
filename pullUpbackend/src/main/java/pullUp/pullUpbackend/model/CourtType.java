package pullUp.pullUpbackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CourtType {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private int court_type;

private String type;

@OneToMany(mappedBy = "courtType")
private Set<BasketballCourt> basketballCourts = new HashSet<>();


    public CourtType() {
    }

    public CourtType(Long id, int court_type, String type){
        this.id = id;
        this.court_type = court_type;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCourt_type() {
        return court_type;
    }

    public void setCourt_type(int court_type) {
        this.court_type = court_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<BasketballCourt> getBasketballCourts() {
        return basketballCourts;
    }

    public void setBasketballCourts(Set<BasketballCourt> basketballCourts) {
        this.basketballCourts = basketballCourts;
    }

    public CourtType addBasketballCourt(BasketballCourt basketballCourt){
        this.basketballCourts.add(basketballCourt);
        basketballCourt.setCourtType(this);
        return this;
    }
}

