package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepo extends JpaRepository<Player,Integer> {
}
