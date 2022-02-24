package com.tekion.cricketmatch.services.beans.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matches {
  @Id private int matchId;
  private int firstTeamId;
  private int secondTeamId;
  private int winningTeam;

  private int firstInningScore;
  private int firstInningWickets;
  private int firstInningOvers;

  private int secondInningScore;
  private int secondInningWickets;
  private int secondInningOvers;
}
