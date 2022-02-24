package com.tekion.cricketmatch.services;

import com.tekion.cricketmatch.services.beans.match.Matches;
import com.tekion.cricketmatch.services.beans.match.inning.Inning;
import com.tekion.cricketmatch.services.beans.player.Player;
import com.tekion.cricketmatch.services.beans.scorecard.ScoreCard;
import com.tekion.cricketmatch.services.repo.IMatchRepo;
import com.tekion.cricketmatch.services.repo.IPlayerRepo;
import com.tekion.cricketmatch.services.repo.IScoreCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    IScoreCardRepo iScoreCardRepo;
    @Autowired
    IMatchRepo iMatchRepo;
    @Autowired
    IPlayerRepo iPlayerRepo;

    public List<Matches> getAllMatches() {
        return this.iMatchRepo.findAll();
    }

    public Matches getMatch(int matchId) {
        return this.iMatchRepo.getById(matchId);
    }


    public String playMatch(int matchId, int firstTeamId, int secondTeamId) {

        Matches m1 = new Matches();

        m1.setMatchId(matchId);
        m1.setFirstTeamId(firstTeamId);
        m1.setSecondTeamId(secondTeamId);
        List<Player> battingTeamPlayers = iPlayerRepo.getAllPlayerByTeamId(firstTeamId);
        List<Player> bowlingTeamPlayers = iPlayerRepo.getAllPlayerByTeamId(secondTeamId);

        Inning firstInnings = new Inning();
        Inning secondInnings = new Inning();
        int totalScore;
        int totalOvers;
        int totalWickets;

        int overs = 8;
        firstInnings.startInnings(battingTeamPlayers,bowlingTeamPlayers,overs);

        totalScore = firstInnings.getTotalScore();
        m1.setFirstInningScore(totalScore);
        totalOvers = firstInnings.getTotalOvers();
        m1.setFirstInningOvers(totalOvers);
        totalWickets = firstInnings.getTotalWickets();
        m1.setFirstInningWickets(totalWickets);

        secondInnings.startInnings(bowlingTeamPlayers,battingTeamPlayers,overs);

        totalScore = secondInnings.getTotalScore();
        m1.setSecondInningScore(totalScore);
        totalOvers = secondInnings.getTotalOvers();
        m1.setSecondInningOvers(totalOvers);
        totalWickets = secondInnings.getTotalWickets();
        m1.setSecondInningWickets(totalWickets);

        if(m1.getFirstInningScore() > m1.getSecondInningScore())
            m1.setWinningTeam(firstTeamId);
        else
            m1.setWinningTeam(secondTeamId);
        iMatchRepo.save(m1);

        for(Player player : battingTeamPlayers) {
            ScoreCard scoreCard = new ScoreCard();
            scoreCard.setMatchId(matchId);
            scoreCard.setPlayerId(player.getPlayerId());
            scoreCard.setTeamId(firstTeamId);
            scoreCard.setPlayerType(player.getPlayerType());

            scoreCard.setRunsScored(player.getRunsScored());
            scoreCard.setBowlPlayed(player.getBowlPlayed());
            scoreCard.setNoOfBoundaries(player.getNoOfBoundaries());

            scoreCard.setOversBowled(player.getOversBowled());
            scoreCard.setWicketsTaken(player.getWicketsTaken());
            scoreCard.setRunsGiven(player.getRunsGiven());

            iScoreCardRepo.save(scoreCard);
        }

        for(Player player : bowlingTeamPlayers) {
            ScoreCard scoreCard = new ScoreCard();
            scoreCard.setMatchId(matchId);
            scoreCard.setPlayerId(player.getPlayerId());
            scoreCard.setTeamId(secondTeamId);
            scoreCard.setPlayerType(player.getPlayerType());

            scoreCard.setRunsScored(player.getRunsScored());
            scoreCard.setBowlPlayed(player.getBowlPlayed());
            scoreCard.setNoOfBoundaries(player.getNoOfBoundaries());

            scoreCard.setOversBowled(player.getOversBowled());
            scoreCard.setWicketsTaken(player.getWicketsTaken());
            scoreCard.setRunsGiven(player.getRunsGiven());

            iScoreCardRepo.save(scoreCard);
        }
        return  "Match Successfully Played";
    }
}