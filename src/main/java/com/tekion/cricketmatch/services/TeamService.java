package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.team.Team;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import com.tekion.cricketmatch.services.repo.ITeamRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    @Autowired
    IPlayerRepo iPlayerRepo;
    @Autowired
    ITeamRepo iTeamRepo;

    public List<Team> getAllTeams() {
        return iTeamRepo.findAll();
    }

    public Team getTeam(int teamId) {
        return iTeamRepo.getById(teamId);
    }

    public Team addTeam(int teamId,String  teamName) {

        List<Player> players = iPlayerRepo.findAll();
        Team team = new Team();
        List<Player>  teamPlayer = new ArrayList<>();
        for(Player player : players) {
            if(player.getTeamId() == teamId)
                teamPlayer.add(player);
        }
        team.setPlayers(teamPlayer);
        team.setTeamName(teamName);
        team.setTeamId(teamId);
        return team;
    }
}