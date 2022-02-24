package com.tekion.cricketmatch.services.repo;

import com.tekion.cricketmatch.services.beans.scorecard.ScoreCard;
import com.tekion.cricketmatch.services.beans.scorecard.ScoreCardPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreCardRepo extends JpaRepository<ScoreCard, ScoreCardPkId> {
}
