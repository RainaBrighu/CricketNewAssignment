package com.tekion.cricketmatch.services.beans.team;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Team {
    @Id
    private int teamId;
    private String teamName;
    private int noOfPlayers;
}
