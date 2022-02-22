package com.tekion.cricketmatch.services.beans.player;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Player {

    @Id
    private int playerId;
    private int teamId;
    private String playerName;
}