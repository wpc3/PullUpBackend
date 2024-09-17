package pullUp.pullUpbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.UserProfile;
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {

    @Query("SELECT U FROM UserProfile U WHERE U.username = ?1")
    UserProfile findProfileByUsername(String username);
}
