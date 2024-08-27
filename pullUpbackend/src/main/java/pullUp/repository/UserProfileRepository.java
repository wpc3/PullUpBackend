package pullUp.repository;

import org.springframework.data.repository.CrudRepository;
import pullUp.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {
}
