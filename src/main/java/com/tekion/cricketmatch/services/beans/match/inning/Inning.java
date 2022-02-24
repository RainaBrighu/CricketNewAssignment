package com.tekion.cricketmatch.services.beans.match.inning;

import com.tekion.cricketmatch.services.beans.player.Player;
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
      if(outcome >= 0 && outcome <= 10) return 0;
      if(outcome >= 11 && outcome <= 35) return 1;
      if(outcome >= 36 && outcome <= 56) return 2;
      if(outcome >= 57 && outcome <= 68) return 3;
      if(outcome >= 69 && outcome <= 80) return 4;
      if(outcome >= 81 && outcome <= 83) return 5;
      if(outcome >= 84 && outcome <= 94) return 6;

      return 7;
    }
  public void updateBattingRecord(int ballResult,List<Player> battingTeamPlayers,int battingStrike) {
    if(ballResult <= 6) {
      int run = battingTeamPlayers.get(battingStrike).getRunsScored();
      battingTeamPlayers.get(battingStrike).setRunsScored(run + ballResult);

      int bowl = battingTeamPlayers.get(battingStrike).getBowlPlayed();
      battingTeamPlayers.get(battingStrike).setBowlPlayed(bowl + 1);

      if(ballResult == 4 || ballResult == 6) {
        int boundary = battingTeamPlayers.get(battingStrike).getNoOfBoundaries();
        battingTeamPlayers.get(battingStrike).setNoOfBoundaries(boundary + 1);
      }
    }
    if(ballResult == 7) {
      int bowl = battingTeamPlayers.get(battingStrike).getBowlPlayed();
      battingTeamPlayers.get(battingStrike).setBowlPlayed(bowl + 1);
    }
  }

  public void updateBowlingRecord(int ballResult,List<Player> bowlingTeamPlayers,int bowlingStrike) {
    if(ballResult == 7) {
      int wicket = bowlingTeamPlayers.get(bowlingStrike).getWicketsTaken();
      bowlingTeamPlayers.get(bowlingStrike).setWicketsTaken(wicket + 1);
    }
    if(ballResult >= 0 && ballResult <=6) {
      int run = bowlingTeamPlayers.get(bowlingStrike).getRunsGiven();
      bowlingTeamPlayers.get(bowlingStrike).setRunsGiven(run + ballResult);
    }
  }

  public void startInnings(List<Player> battingTeamPlayers, List<Player> bowlingTeamPlayers,int overs) {

    int temp;

    int batsmanStrike = 0;
    int batsmanNonStrike = 1;
    int bowlerBowling = 11;

    for (int i = 1; i <= overs; i++) {
      bowlerBowling = bowlerBowling - 1;
      if (bowlerBowling == 5)
        bowlerBowling = 10;
      for (int b = 1; b <= 6; b++) {
        int ballResult = playBall();
        if (ballResult <= 6) {
          System.out.println("Over : " + i + " Ball : " + b + " Runs : " + ballResult);
          totalScore = totalScore + ballResult;
          updateBattingRecord(ballResult, battingTeamPlayers, batsmanStrike);
          updateBowlingRecord(ballResult, bowlingTeamPlayers,bowlerBowling);
          if(ballResult % 2 != 0) {
            temp = batsmanStrike;
            batsmanStrike = bowlerBowling;
            bowlerBowling = temp;
          }
        }
        if(ballResult == 7) {
          totalWickets = totalWickets + 1;
          updateBattingRecord(ballResult, battingTeamPlayers, batsmanStrike);
          updateBowlingRecord(ballResult, bowlingTeamPlayers,bowlerBowling);
          if(totalWickets == 10)
            break;
          if (batsmanStrike < batsmanNonStrike)
                batsmanStrike = batsmanNonStrike + 1;
          else
            batsmanStrike = batsmanStrike + 1;
        }
      }
      totalOvers = totalOvers + 1;
      temp = batsmanStrike;
      batsmanStrike = bowlerBowling;
      bowlerBowling = temp;
      overs = bowlingTeamPlayers.get(bowlerBowling).getOversBowled();
      bowlingTeamPlayers.get(bowlerBowling).setOversBowled(overs + 1);
      if(totalWickets == 10)
        break;
    }
  }
}