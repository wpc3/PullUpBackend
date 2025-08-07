package pullUp.pullUpbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Entity
public class PlayerRank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int playerRank;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private UserProfile player;

    @ManyToOne
    @JoinColumn(name = "ranker_id")
    private UserProfile ranker;

//    @ManyToMany(mappedBy = "playerRanks")
//    @JsonIgnore
//    private Set<UserProfile> userProfiles = new HashSet<>();

    public PlayerRank() {
    }

    public PlayerRank(Long id, int playerRank) {
        this.playerRank = playerRank;
        this.id = id;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getPlayer() {
        return player;
    }

    public void setPlayer(UserProfile player) {
        this.player = player;
    }

    public UserProfile getRanker() {
        return ranker;
    }

    public void setRanker(UserProfile ranker) {
        this.ranker = ranker;
    }

    //    public Set<UserProfile> getUserProfiles() {
//        return userProfiles;
//    }
//
//    public void setUserProfiles(Set<UserProfile> userProfiles) {
//        this.userProfiles = userProfiles;
//    }
}
