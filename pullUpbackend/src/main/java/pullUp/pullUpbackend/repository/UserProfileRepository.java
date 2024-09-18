package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.UserProfile;
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {

    @Query("SELECT U FROM UserProfile U WHERE U.username = ?1")
    UserProfile findProfileByUsername(String username);

    @Query(value = "SELECT u.* FROM user_profile u JOIN SAVED_COURTS s ON u.id = s.user_profile_id JOIN basketball_court b ON b.id = s.ball_court_id WHERE u.username = :username", nativeQuery = true)
   UserProfile findSavedCourtsByUsername(String username);

}