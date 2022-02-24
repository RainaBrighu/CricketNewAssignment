package com.tekion.cricketmatch.api;

import com.tekion.cricketmatch.services.MatchService;
import com.tekion.cricketmatch.services.beans.match.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/match")
    public List<Matches> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/match/{matchId}")
    public Matches getMatch(@PathVariable int matchId) {
        return matchService.getMatch(matchId);
    }

    @PostMapping("/match/{matchId}/{firstTeamId}/{secondTeamId}")
    public String playMatch(@PathVariable int matchId,@PathVariable int firstTeamId, @PathVariable int secondTeamId) {
        return  matchService.playMatch(matchId,firstTeamId,secondTeamId);
    }
}