package com.tekion.cricketmatch.services.beans.scorecard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ScoreCardPkId implements Serializable {
  private int matchId;
  private int playerId;
}
