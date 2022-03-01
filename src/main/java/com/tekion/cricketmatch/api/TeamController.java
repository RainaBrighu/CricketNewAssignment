package com.tekion.cricketmatch.api;

import com.tekion.cricketmatch.services.TeamService;
import com.tekion.cricketmatch.services.beans.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

  @Autowired TeamService teamService;

  @GetMapping("/teams")
  public List<Team> getAllTeams() {
    return teamService.getAllTeams();
  }

  @GetMapping("/team/{teamId}")
  public Team getTeam(@PathVariable("teamId") int teamId) {
    return teamService.getTeam(teamId);
  }

  @PostMapping("/add/{teamId}/{teamName}")
  public Team addTeam(
      @PathVariable("teamId") int teamId, @PathVariable("teamName") String teamName) {
    return teamService.addTeam(teamId, teamName);
  }
}
