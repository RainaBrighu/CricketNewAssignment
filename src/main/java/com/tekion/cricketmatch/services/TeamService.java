package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.team.Team;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import com.tekion.cricketmatch.services.repo.ITeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    List<Team> finalTeam = new ArrayList<>();
    @Autowired
    IPlayerRepo iPlayerRepo;
    //@Autowired
    //ITeamRepo iTeamRepo;

    public List<Team> getAllTeams() {
        //return iTeamRepo.findAll();
        return this.finalTeam;
    }

    public Team getTeam(int teamId) {
        //return iTeamRepo.getById(teamId);
        Team t1 = new Team();
        for(Team team : finalTeam) {
            if(team.getTeamId() == teamId)
                t1 =  team;
        }
        return t1;
    }

    public Team addTeam(int teamId,String  teamName) {

        List<Player> players = iPlayerRepo.findAll();
        Team team = new Team();
        List<Player>  teamPlayer = new ArrayList<>();
        for(Player player : players) {
            if(player.getTeamId() == teamId)
                teamPlayer.add(player);
            if(teamPlayer.size() == 11)
                break;
        }
        team.setPlayers(teamPlayer);
        team.setTeamName(teamName);
        team.setTeamId(teamId);
        //iTeamRepo.save(team);
        finalTeam.add(team);
        return team;
    }
}