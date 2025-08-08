package pullUp.pullUpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pullUp.pullUpbackend.model.PlayerRank;
import pullUp.pullUpbackend.model.UserProfile;
import pullUp.pullUpbackend.repository.PlayerRankRepository;
import pullUp.pullUpbackend.repository.UserProfileRepository;

import java.util.List;

@Service
public class PlayerRankService {

    private PlayerRankRepository repository;
    private UserProfileRepository userProfileRepository;

    public PlayerRankService(@Autowired PlayerRankRepository repository,
                             @Autowired UserProfileRepository userProfileRepository) {
        this.repository = repository;
        this.userProfileRepository = userProfileRepository;
    }

    public PlayerRank rankAPlayer(Long userId, Long rankedPlayerId, PlayerRank playerRank ){
        UserProfile user = userProfileRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        UserProfile rankedPlayer = userProfileRepository.findById(rankedPlayerId).orElseThrow(() -> new RuntimeException("user not found"));

        playerRank.setRanker(user);
        playerRank.setPlayer(rankedPlayer);
        user.getGivenRankings().add(playerRank);
        rankedPlayer.getRecievedRanksings().add(playerRank);

        return repository.save(playerRank);

    }
}
