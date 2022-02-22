package com.tekion.cricketmatch.services.beans.player;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Bowler extends Batsman{
    private int oversBowled;
    private int wicketsTaken;
    private int runsGiven;
}
