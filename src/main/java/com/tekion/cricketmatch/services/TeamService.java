package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.entities.player.Batsman;
import com.tekion.cricketmatch.entities.player.Bowler;
import com.tekion.cricketmatch.entities.player.Player;
import com.tekion.cricketmatch.repository.Team1Repository;
import com.tekion.cricketmatch.repository.Team2Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamService {
/*
    @Autowired
    Team1Repository team1Repository;
    @Autowired
    Team2Repository team2Repository;

    public List<Player> getAllPlayers(String team) {
        if(team.equals("team1"))
            return team1Repository.findAll();
        else
            return team2Repository.findAll();
    }

    public Player getPlayer(String team, int playerId) {
        if(team.equals("team1"))
            return team1Repository.findById(playerId).get();
        else
            return team2Repository.findById(playerId).get();
    }

    public Batsman addBatsman(String team,Batsman batsman) {
        if(team.equals("team1"))
            return team1Repository.save(batsman);
        else
            return team2Repository.save(batsman);
    }

    public Bowler addBowler(String team,Bowler bowler) {
        if(team.equals("team1"))
            return team1Repository.save(bowler);
        else
            return team2Repository.save(bowler);
    }

    public Batsman updateBatsman(String team,Batsman batsman) {
        if(team.equals("team1"))
            return team1Repository.save(batsman);
        else
            return team2Repository.save(batsman);
    }

    public Bowler updateBowler(String team,Bowler bowler) {
        if(team.equals("team1"))
            return team1Repository.save(bowler);
        else
            return team2Repository.save(bowler);
    }

 */
}