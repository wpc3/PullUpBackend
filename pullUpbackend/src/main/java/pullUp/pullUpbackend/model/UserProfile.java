package pullUp.pullUpbackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class UserProfile {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String username;
private String password;


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