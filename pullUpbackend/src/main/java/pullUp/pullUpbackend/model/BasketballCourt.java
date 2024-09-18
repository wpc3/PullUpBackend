package pullUp.pullUpbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BasketballCourt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String court_name;
    private String state;
    private Integer zipcode;
    private String address;
    private String longitude;
    private String latitude;

    @ManyToMany( mappedBy = "basketballCourts")
    @JsonIgnore
    private Set<UserProfile> userProfiles = new HashSet<>();

    public BasketballCourt(){}

    public BasketballCourt(String court_name, String state, Integer zipcode, String address, String longitude, String latitude ){
        this.court_name = court_name;
        this.state =state;
        this.zipcode = zipcode;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourt_name() {
        return court_name;
    }

    public void setCourt_name(String court_name) {
        this.court_name = court_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLongitude() {
        return longitude;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public String toString() {
        return "BasketballCourt{" +
                "id=" + id +
                ", court_name='" + court_name + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", address='" + address + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", userProfiles=" + userProfiles +
                '}';
    }
}
