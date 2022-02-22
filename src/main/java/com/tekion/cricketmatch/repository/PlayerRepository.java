package com.tekion.cricketmatch.repository;

import com.tekion.cricketmatch.entities.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
