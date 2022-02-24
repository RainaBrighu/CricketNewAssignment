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

  @Autowired IScoreCardRepo iScoreCardRepo;
  @Autowired IMatchRepo iMatchRepo;
  @Autowired IPlayerRepo iPlayerRepo;

  public List<Matches> getAllMatches() {
    return this.iMatchRepo.findAll();
  }

  public Matches getMatch(int matchId) {
    return this.iMatchRepo.getById(matchId);
  }

  public void savePlayersToScoreCard(int matchId, int teamId, List<Player> teamPlayers) {
    for (Player player : teamPlayers) {
      ScoreCard scoreCard = new ScoreCard();
      scoreCard.setMatchId(matchId);
      scoreCard.setPlayerId(player.getPlayerId());

      scoreCard.setTeamId(teamId);
      scoreCard.setPlayerName(player.getPlayerName());
      scoreCard.setPlayerType(player.getPlayerType());

      scoreCard.setRunsScored(player.getRunsScored());
      scoreCard.setBowlPlayed(player.getBowlPlayed());
      scoreCard.setNoOfBoundaries(player.getNoOfBoundaries());

      scoreCard.setOversBowled(player.getOversBowled());
      scoreCard.setWicketsTaken(player.getWicketsTaken());
      scoreCard.setRunsGiven(player.getRunsGiven());

      iScoreCardRepo.save(scoreCard);
    }
  }

  public void saveScoreCard(int matchId, int teamId, List<ScoreCard> teamPlayers) {
    for (ScoreCard player : teamPlayers) {
      ScoreCard scoreCard = new ScoreCard();
      scoreCard.setMatchId(matchId);
      scoreCard.setPlayerId(player.getPlayerId());

      scoreCard.setTeamId(teamId);
      scoreCard.setPlayerName(player.getPlayerName());
      scoreCard.setPlayerType(player.getPlayerType());

      scoreCard.setRunsScored(player.getRunsScored());
      scoreCard.setBowlPlayed(player.getBowlPlayed());
      scoreCard.setNoOfBoundaries(player.getNoOfBoundaries());

      scoreCard.setOversBowled(player.getOversBowled());
      scoreCard.setWicketsTaken(player.getWicketsTaken());
      scoreCard.setRunsGiven(player.getRunsGiven());

      iScoreCardRepo.save(scoreCard);
    }
  }

  public String playMatch(Matches match) {

    List<Player> firstTeamPlayers = iPlayerRepo.getAllPlayerByTeamId(match.getFirstTeamId());
    List<Player> secondTeamPlayers = iPlayerRepo.getAllPlayerByTeamId(match.getSecondTeamId());

    savePlayersToScoreCard(match.getMatchId(), match.getFirstTeamId(), firstTeamPlayers);
    savePlayersToScoreCard(match.getMatchId(), match.getSecondTeamId(), secondTeamPlayers);

    Inning firstInnings = new Inning();
    Inning secondInnings = new Inning();
    int totalScore;
    int totalOvers;
    int totalWickets;

    int overs = 8;

    List<ScoreCard> battingTeamPlayers =
        iScoreCardRepo.getAllPlayerByTeamId(match.getMatchId(), match.getFirstTeamId());
    List<ScoreCard> bowlingTeamPlayers =
        iScoreCardRepo.getAllPlayerByTeamId(match.getMatchId(), match.getSecondTeamId());

    firstInnings.startInnings(0, battingTeamPlayers, bowlingTeamPlayers, overs);

    totalScore = firstInnings.getTotalScore();
    match.setFirstInningScore(totalScore);
    totalOvers = firstInnings.getTotalOvers();
    match.setFirstInningOvers(totalOvers);
    totalWickets = firstInnings.getTotalWickets();
    match.setFirstInningWickets(totalWickets);

    secondInnings.startInnings(
        firstInnings.getTotalScore(), bowlingTeamPlayers, battingTeamPlayers, overs);

    totalScore = secondInnings.getTotalScore();
    match.setSecondInningScore(totalScore);
    totalOvers = secondInnings.getTotalOvers();
    match.setSecondInningOvers(totalOvers);
    totalWickets = secondInnings.getTotalWickets();
    match.setSecondInningWickets(totalWickets);

    if (match.getFirstInningScore() > match.getSecondInningScore())
      match.setWinningTeam(match.getFirstTeamId());
    else match.setWinningTeam(match.getSecondTeamId());
    iMatchRepo.save(match);

    saveScoreCard(match.getMatchId(), match.getFirstTeamId(), battingTeamPlayers);
    saveScoreCard(match.getMatchId(), match.getSecondTeamId(), bowlingTeamPlayers);

    return "Match Successfully Played";
  }

  public List<ScoreCard> getMatchScoreCard(int matchId) {
    return iScoreCardRepo.getAllPlayerByMatchId(matchId);
  }
}
