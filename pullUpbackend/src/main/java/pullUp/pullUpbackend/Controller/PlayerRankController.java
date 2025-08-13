package pullUp.pullUpbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pullUp.pullUpbackend.model.PlayerRank;
import pullUp.pullUpbackend.service.PlayerRankService;

@RestController
public class PlayerRankController {

    private PlayerRankService playerRankService;

    public PlayerRankController(@Autowired PlayerRankService playerRankService) {
        this.playerRankService = playerRankService;
    }

    @PostMapping("/playerRank/{userId}/{rankedPlayerId}")
    public ResponseEntity<PlayerRank> postPlayerRank(@PathVariable Long userId, @PathVariable Long rankedPlayerId, @RequestBody PlayerRank playerRank){

        return new ResponseEntity<>(playerRankService.rankAPlayer(userId, rankedPlayerId, playerRank),HttpStatus.CREATED);
    }

    @GetMapping("/playerRank/rankings/{id}")
    public ResponseEntity<Double> getPlayerRankById(@PathVariable Long id){
        return new ResponseEntity<>(playerRankService.showAverageRankById(id), HttpStatus.OK);
    }
}
