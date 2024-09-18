package pullUp.pullUpbackend.model;
import jakarta.persistence.*;

import java.util.List;

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
private List<BasketballCourts> basketballCourts;

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