package com.tekion.cricketmatch.services.beans.player;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Batsman extends Player{
    private int runsScored;
    private int bowlPlayed;
    private int noOfBoundaries;
}
