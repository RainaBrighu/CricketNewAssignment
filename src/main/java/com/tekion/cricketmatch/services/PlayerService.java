package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.player.Batsman;
import com.tekion.cricketmatch.services.beans.player.Bowler;
import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    IPlayerRepo IPlayerRepo;

    public List<Player> getAllPlayer() {
        return IPlayerRepo.findAll();
    }

    public Player getPlayer(int playerId ) {
        return IPlayerRepo.findById(playerId).get();
    }

    public  Batsman addBatsman(Batsman batsman) {
        IPlayerRepo.save(batsman);
        return batsman;
    }

    public Bowler addBowler(Bowler bowler) {
        IPlayerRepo.save(bowler);
        return bowler;
    }
}