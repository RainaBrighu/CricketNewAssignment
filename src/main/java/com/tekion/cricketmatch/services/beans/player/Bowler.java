package com.tekion.cricketmatch.services.beans.player;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bowler extends Batsman {

    @Column
    private int oversBowled;
    @Column
    private int wicketsTaken;
    @Column
    private int runsGiven;

    public int getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }
}