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
    IPlayerRepo iPlayerRepo;

    public List<Player> getAllPlayer() {
        return iPlayerRepo.findAll();
    }

    public Player getPlayer(int playerId ) {
        return iPlayerRepo.getById(playerId);
    }

    public  Batsman addBatsman(Batsman batsman) {
        iPlayerRepo.save(batsman);
        return batsman;
    }

    public Bowler addBowler(Bowler bowler) {
        iPlayerRepo.save(bowler);
        return bowler;
    }
}