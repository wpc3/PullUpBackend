package pullUp.pullUpbackend.repository;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pullUp.pullUpbackend.model.PlayerRank;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.service.PlayerRankService;

@Repository
public interface PlayerRankRepository extends CrudRepository<PlayerRank,Long> {

    @Query(value = "SELECT AVG(player_rank) FROM player_rank WHERE player_id = 1?", nativeQuery = true)

   PlayerRank averagePlayerRankById(Long id);
}
