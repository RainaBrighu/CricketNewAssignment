package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.team.Team;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import com.tekion.cricketmatch.services.repo.ITeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

  @Autowired IPlayerRepo iPlayerRepo;
  @Autowired ITeamRepo iTeamRepo;

  public List<Team> getAllTeams() {
    return this.iTeamRepo.findAll();
  }

  public Team getTeam(int teamId) {
    return this.iTeamRepo.getById(teamId);
  }

  public Team addTeam(int teamId, String teamName) {

    Team team = new Team();
    List<Player> players = iPlayerRepo.getAllPlayerByTeamId(teamId);

    int teamSize = players.size();
    team.setTeamName(teamName);
    team.setTeamId(teamId);
    team.setNoOfPlayers(teamSize);
    iTeamRepo.save(team);
    return team;
  }
}
