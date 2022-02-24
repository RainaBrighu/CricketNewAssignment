package com.tekion.cricketmatch.api;

import com.tekion.cricketmatch.services.TeamService;
import com.tekion.cricketmatch.services.beans.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

  @Autowired TeamService teamService;

  @GetMapping("/team")
  public List<Team> getAllTeams() {
    return teamService.getAllTeams();
  }

  @GetMapping("/team/{teamId}")
  public Team getTeam(@PathVariable int teamId) {
    return teamService.getTeam(teamId);
  }

  @PostMapping("/add/{teamId}/{teamName}")
  public Team addTeam(@PathVariable int teamId, @PathVariable String teamName) {
    return teamService.addTeam(teamId, teamName);
  }
}
