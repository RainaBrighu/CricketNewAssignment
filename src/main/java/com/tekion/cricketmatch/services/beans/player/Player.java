package com.tekion.cricketmatch.services.beans.player;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

  @Id
  private int playerId;

  private String playerName;

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

}

