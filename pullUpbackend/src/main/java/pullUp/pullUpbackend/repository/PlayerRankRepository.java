package pullUp.pullUpbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.PlayerRank;
import pullUp.pullUpbackend.model.UserProfile;

@Repository
public interface PlayerRankRepository extends CrudRepository<PlayerRank,Long> {
}
