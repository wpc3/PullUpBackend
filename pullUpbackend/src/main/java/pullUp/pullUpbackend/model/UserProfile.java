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
private int userRank;

@ManyToMany
@JoinTable(
        name = "savedCourts",
        joinColumns = @JoinColumn(name = "userProfile_id"),
        inverseJoinColumns = @JoinColumn(name = "ballCourt_id")
)
private Set<BasketballCourt> basketballCourts = new HashSet<>();

@ManyToMany
@JoinTable(
        name = "friendships",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id")
)
private Set<UserProfile> userProfiles = new HashSet<>();



public UserProfile(){}

public UserProfile(Long id,String username, String password, int userRank) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.userRank = userRank;


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

    public UserProfile addBasketballCourt(BasketballCourt basketballCourt){
    this.basketballCourts.add(basketballCourt);
    basketballCourt.getUserProfiles().add(this);
    return this;
    }

    public UserProfile removeBasketballCourt(BasketballCourt basketballCourt){
    this.basketballCourts.remove(basketballCourt);
    basketballCourt.getUserProfiles().remove(this);

    return this;
    }

    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public UserProfile addUserProfile(UserProfile userProfile){
        this.userProfiles.add(userProfile);
        userProfile.getUserProfiles().add(this);

        return this;

    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRank=" + userRank +
                ", basketballCourts=" + basketballCourts +
                ", userProfiles=" + userProfiles +
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