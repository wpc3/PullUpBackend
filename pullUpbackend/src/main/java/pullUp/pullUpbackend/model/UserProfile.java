package pullUp.pullUpbackend.model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserProfile {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String username;
private String password;

@ManyToMany
@JoinTable(
        name = "savedCourts",
        joinColumns = @JoinColumn(name = "userProfile_id"),
        inverseJoinColumns = @JoinColumn(name = "ballCourt_id")
)
private Set<BasketballCourt> basketballCourts = new HashSet<>();

public UserProfile(){}

public UserProfile(Long id,String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;


}



public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

    public Set<BasketballCourt> getBasketballCourts() {
        return basketballCourts;
    }

    public void setBasketballCourts(Set<BasketballCourt> basketballCourts) {
        this.basketballCourts = basketballCourts;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", basketballCourts=" + basketballCourts +
                '}';
    }

//public String getLongitude() {
//    return longitude;
//}


//public void setLongitude(String longitude) {
//    this.longitude = longitude;
//}
//
//public String getLatitude() {
//    return latitude;
//}
//
//public void setLatitude(String latitude) {
//    this.latitude = latitude;
//}

}