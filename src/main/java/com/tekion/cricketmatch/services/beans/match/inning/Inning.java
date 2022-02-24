package com.tekion.cricketmatch.services.beans.match.inning;

import com.tekion.cricketmatch.services.beans.scorecard.ScoreCard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.random;

@Getter
@Setter
public class Inning {

  private int totalScore;
  private int totalOvers;
  private int totalWickets;

  public int playBall() {
    int outcome = (int) floor(random() * 100);
    if (outcome >= 0 && outcome <= 10) return 0;
    if (outcome >= 11 && outcome <= 35) return 1;
    if (outcome >= 36 && outcome <= 56) return 2;
    if (outcome >= 57 && outcome <= 68) return 3;
    if (outcome >= 69 && outcome <= 80) return 4;
    if (outcome >= 81 && outcome <= 83) return 5;
    if (outcome >= 84 && outcome <= 94) return 6;

    return 7;
  }

  public void updateBatsmanRecord(
      List<ScoreCard> battingTeamPlayers, int batsmanStrike, int ballResult) {
    if (ballResult <= 6) {
      int run = battingTeamPlayers.get(batsmanStrike).getRunsScored();
      battingTeamPlayers.get(batsmanStrike).setRunsScored(run + ballResult);
      int bowl = battingTeamPlayers.get(batsmanStrike).getBowlPlayed();
      battingTeamPlayers.get(batsmanStrike).setBowlPlayed(bowl + 1);
      if (ballResult == 4 || ballResult == 6) {
        int boundary = battingTeamPlayers.get(batsmanStrike).getNoOfBoundaries();
        battingTeamPlayers.get(batsmanStrike).setNoOfBoundaries(boundary + 1);
      }
    }
    if (ballResult == 7) {
      int bowl = battingTeamPlayers.get(batsmanStrike).getBowlPlayed();
      battingTeamPlayers.get(batsmanStrike).setBowlPlayed(bowl + 1);
    }
  }

  public void updateBowlerRecord(
      List<ScoreCard> bowlingTeamPlayers, int bowlerBowling, int ballResult) {
    if (ballResult == 7) {
      int wicket = bowlingTeamPlayers.get(bowlerBowling).getWicketsTaken();
      bowlingTeamPlayers.get(bowlerBowling).setWicketsTaken(wicket + 1);
    }
    if (ballResult <= 6) {
      int runs = bowlingTeamPlayers.get(bowlerBowling).getRunsGiven();
      bowlingTeamPlayers.get(bowlerBowling).setRunsGiven(runs + ballResult);
    }
  }

  public void startInnings(
      int inningsScore,
      List<ScoreCard> battingTeamPlayers,
      List<ScoreCard> bowlingTeamPlayers,
      int overs) {

    int batsmanStrike = 0;
    int batsmanNonStrike = 1;
    int bowlerBowling = 11;
    int strikeChange;

    for (int i = 1; i <= overs; i++) {
      bowlerBowling = bowlerBowling - 1;
      if (bowlerBowling == 5) bowlerBowling = 10;
      for (int bowl = 1; bowl <= 6; bowl++) {

        int ballResult = playBall();
        if (ballResult <= 6) {
          totalScore = totalScore + ballResult;
          updateBatsmanRecord(battingTeamPlayers, batsmanStrike, ballResult);
          updateBowlerRecord(bowlingTeamPlayers, bowlerBowling, ballResult);
          if (ballResult % 2 != 0) {
            strikeChange = batsmanStrike;
            batsmanStrike = batsmanNonStrike;
            batsmanNonStrike = strikeChange;
          }
        }
        if (ballResult == 7) {
          totalWickets = totalWickets + 1;
          updateBatsmanRecord(battingTeamPlayers, batsmanStrike, ballResult);
          updateBowlerRecord(bowlingTeamPlayers, bowlerBowling, ballResult);
          if (totalWickets == 10) break;
          if (batsmanStrike < batsmanNonStrike) batsmanStrike = batsmanNonStrike + 1;
          else batsmanStrike = batsmanStrike + 1;
        }
        if (inningsScore != 0 && inningsScore < totalScore) {
          return;
        }
      }
      if (totalWickets == 10) break;
      int over = bowlingTeamPlayers.get(bowlerBowling).getOversBowled();
      bowlingTeamPlayers.get(bowlerBowling).setOversBowled(over + 1);
      totalOvers = totalOvers + 1;
      strikeChange = batsmanStrike;
      batsmanStrike = batsmanNonStrike;
      batsmanNonStrike = strikeChange;
    }
  }
}
