package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlayerRepo extends JpaRepository<Player,Integer> {

    @Query(value = "SELECT * FROM player p WHERE p.team_id = ?1",
          nativeQuery = true)
    List<Player> getAllPlayerById(Integer teamId);
}
