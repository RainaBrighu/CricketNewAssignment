package com.tekion.cricketmatch.services.beans.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  @Id @GeneratedValue() private int playerId;
  private int teamId;
  private String playerName;
  private PlayerType playerType;

  private int runsScored;
  private int bowlPlayed;
  private int noOfBoundaries;

  private int oversBowled;
  private int wicketsTaken;
  private int runsGiven;
}
