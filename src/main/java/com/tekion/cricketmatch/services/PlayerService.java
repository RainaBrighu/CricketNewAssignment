package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.entities.player.Batsman;
import com.tekion.cricketmatch.entities.player.Bowler;
import com.tekion.cricketmatch.entities.player.Player;
import com.tekion.cricketmatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int playerId ) {
        return playerRepository.findById(playerId).get();
    }

    public  Batsman addBatsman(Batsman batsman) {
        playerRepository.save(batsman);
        return batsman;
    }

    public Bowler addBowler(Bowler bowler) {
        playerRepository.save(bowler);
        return bowler;
    }
}