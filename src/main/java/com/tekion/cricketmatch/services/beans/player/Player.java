package com.tekion.cricketmatch.services.beans.player;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PlayerPkId.class)
public class Player {

    @Id
    private int playerId;
    @Id
    private int teamId;
    private String playerName;
    private String playerType;

    private int runsScored;
    private int bowlPlayed;
    private int noOfBoundaries;

    private int oversBowled;
    private int wicketsTaken;
    private int runsGiven;
}