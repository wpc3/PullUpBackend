package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.UserProfile;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {

//      @Query("SELECT U FROM UserProfile U WHERE U.username = ?1")
     UserProfile findProfileByUsername(String username);

    @Query(value = "SELECT u.* FROM user_profile u JOIN SAVED_COURTS s ON u.id = s.user_profile_id JOIN basketball_court b ON b.id = s.ball_court_id WHERE u.username = :username", nativeQuery = true)
   UserProfile findSavedCourtsByUsername(String username);

   boolean existsByUsername(String username);

   @Query(value =  "select p.username from user_profile u join friendships f on f.user_id = u.id join user_profile p on f.friend_id = p.id where f.user_id = ?", nativeQuery = true)
    List<String> findFriendsByUserId(Long id);

   @Query(value = "select u.username from user_profile u join player_rank r on u.id = r.player_id group by u.username having avg(player_rank) = ?", nativeQuery = true)
   List<String> findProfileByRanking(Integer ranking);

}