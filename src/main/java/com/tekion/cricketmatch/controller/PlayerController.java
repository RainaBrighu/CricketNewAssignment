package com.tekion.cricketmatch.controller;

import com.tekion.cricketmatch.entities.player.Batsman;
import com.tekion.cricketmatch.entities.player.Bowler;
import com.tekion.cricketmatch.entities.player.Player;
import com.tekion.cricketmatch.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class PlayerController {

    @Autowired
    private PlayerService playerService;

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
