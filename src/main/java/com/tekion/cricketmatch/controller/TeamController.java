package com.tekion.cricketmatch.controller;

import com.tekion.cricketmatch.entities.player.Batsman;
import com.tekion.cricketmatch.entities.player.Bowler;
import com.tekion.cricketmatch.entities.player.Player;
import com.tekion.cricketmatch.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
/*
    @Autowired
    TeamService teamService;

    @GetMapping("/{team}/players")
    public List<Player> getAllPlayers(@PathVariable String team) {
        return this.teamService.getAllPlayers(team);
    }

    @GetMapping("/{team}/players/{id}")
    public Player getPlayer(@PathVariable String team,@PathVariable int playerId) {
        return this.teamService.getPlayer(team,playerId);
    }

    @PostMapping("/{team}/add/batsman")
    public Batsman addBatsman(@PathVariable String team,@RequestBody Batsman batsman) {
        return this.teamService.addBatsman(team,batsman);
    }

    @PostMapping("/{team}/add/bowler")
    public Bowler addBowler(@PathVariable String team,@RequestBody Bowler bowler) {
        return this.teamService.addBowler(team,bowler);
    }

    @PutMapping("/{team}/update/batsman")
    public Batsman updateBatsman(@PathVariable String team,@RequestBody Batsman batsman) {
        return this.teamService.updateBatsman(team,batsman);
    }

    @PutMapping("/{team}/update/bowler")
    public Bowler updateBowler(@PathVariable String team,@RequestBody Bowler bowler) {
        return this.teamService.updateBowler(team,bowler);
    }

 */
}
