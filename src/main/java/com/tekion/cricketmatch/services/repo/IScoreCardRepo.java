package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.scorecard.ScoreCard;
import com.tekion.cricketmatch.services.beans.scorecard.ScoreCardPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScoreCardRepo extends JpaRepository<ScoreCard, ScoreCardPkId> {

    @Query(value = "SELECT * FROM score_card sc WHERE sc.match_id = ?1 and sc.team_id = ?2",nativeQuery = true)
    List<ScoreCard> getAllPlayerByTeamId(Integer matchId,Integer teamId);

    @Query(value = "SELECT * FROM score_card sc WHERE sc.match_id = ?1",nativeQuery = true)
    List<ScoreCard> getAllPlayerByMatchId(Integer teamId);
    
}
