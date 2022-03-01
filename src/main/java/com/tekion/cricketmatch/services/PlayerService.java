package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.player.PlayerType;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  @Autowired IPlayerRepo iPlayerRepo;

  public List<Player> getAllPlayer() {
    return (iPlayerRepo.findAll());
  }

  public Player getPlayer(int playerId) {
    return iPlayerRepo.getById(playerId);
  }

  public Player addPlayer(Player player) {
    Player player1 = new Player();

    player1.setPlayerId(player.getPlayerId());
    player1.setTeamId(player.getTeamId());
    player1.setPlayerName(player.getPlayerName());

    if (player.getPlayerType() == PlayerType.BATSMAN) player1.setPlayerType(PlayerType.BATSMAN);
    else player1.setPlayerType(PlayerType.BOWLER);

    iPlayerRepo.save(player);
    return player;
  }
}
