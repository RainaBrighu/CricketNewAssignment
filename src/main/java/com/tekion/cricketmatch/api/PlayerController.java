package com.tekion.cricketmatch.api;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

  @Autowired private PlayerService playerService;

  @GetMapping("/player")
  public List<Player> getAllPlayer() {
    return this.playerService.getAllPlayer();
  }

  @GetMapping("/player/{playerId}")
  public Player getPlayer(@PathVariable int playerId) {
    return this.playerService.getPlayer(playerId);
  }

  @PostMapping("/add/player")
  public Player addBatsman(@RequestBody Player player) {
    return this.playerService.addPlayer(player);
  }
}
