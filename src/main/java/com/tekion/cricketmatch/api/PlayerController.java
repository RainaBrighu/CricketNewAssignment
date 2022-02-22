package com.tekion.cricketmatch.api;

import com.tekion.cricketmatch.services.PlayerService;
import com.tekion.cricketmatch.services.beans.player.Batsman;
import com.tekion.cricketmatch.services.beans.player.Bowler;
import com.tekion.cricketmatch.services.beans.player.Player;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerController {

  // todo : use required args contractor
  private final PlayerService playerService;

  @GetMapping("/player")
  public List<Player> getAllPlayer() {
    return this.playerService.getAllPlayer();
  }

  @GetMapping("/player/{playerId}")
  public Player getBatsman(@PathVariable int playerId) {
    return this.playerService.getPlayer(playerId);
  }

  @PostMapping("/add/batsman")
  public Batsman addBatsman(@RequestBody Batsman batsman) {
    return this.playerService.addBatsman(batsman);
  }

  @PostMapping("/add/bowler")
  public Bowler addBowler(@RequestBody Bowler bowler) {
    return this.playerService.addBowler(bowler);
  }

}
