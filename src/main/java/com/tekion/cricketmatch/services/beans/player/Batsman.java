package com.tekion.cricketmatch.services.beans.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

// todo: remove Entity, Columns if not needed explicitly
@Data
@Entity
public class Batsman extends Player {

    private int runsScored;
    @Column
    private int bowlPlayed;
    @Column
    private int noOfBoundaries;

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBowlPlayed() {
        return bowlPlayed;
    }

    public void setBowlPlayed(int bowlPlayed) {
        this.bowlPlayed = bowlPlayed;
    }

    public int getNoOfBoundaries() {
        return noOfBoundaries;
    }

    public void setNoOfBoundaries(int noOfBoundaries) {
        this.noOfBoundaries = noOfBoundaries;
    }
}