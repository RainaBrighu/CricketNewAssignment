package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepo extends JpaRepository<Team,Integer> {
}
