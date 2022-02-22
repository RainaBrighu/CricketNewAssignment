package com.tekion.cricketmatch.services.beans.team;

import com.tekion.cricketmatch.services.beans.player.Player;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter
@Setter
public class Team {

    private int teamId;
    private String teamName;
    private List<Player> players = new ArrayList<>();

}
