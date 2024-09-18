package pullUp.pullUpbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BasketballCourts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String state;
    private Integer zipcode;
    private String address;
    private String longitude;
    private String latitude;

    public BasketballCourts(){}

    public BasketballCourts(String name, String state, Integer zipcode, String address, String longitude, String latitude ){
        this.name = name;
        this.state =state;
        this.zipcode = zipcode;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
