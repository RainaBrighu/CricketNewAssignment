package com.tekion.cricketmatch.temp;

public class Inning {
    /*
    private final Team battingTeam;
    private final Team bowlingTeam;

    public  Inning(Team team1, Team team2){
        this.battingTeam = team1;
        this.bowlingTeam = team2;
    }

    public void updateInningStats(int totalRuns, int totalWickets, InningStats inningStats) {
        inningStats.setInningScore(totalRuns);
        inningStats.setInningWickets(totalWickets);
    }

    public void updatePlayerRecord(int batsmanStrike,int runScored,int bowlerBowling,int bats) {
        int run;
        int bowl;
        if(batsmanStrike < bats) {
            if (battingTeam.getTeamPlayers().get(batsmanStrike) instanceof Batsman bat1) {
                run = bat1.getRunsScored();
                bat1.setRunsScored(run + runScored);
                bowl = bat1.getBowlPlayed();
                bat1.setBowlPlayed(bowl + 1);
                if(runScored == 4 || runScored == 6) {
                    int boundary = bat1.getNoOfBoundaries();
                    bat1.setNoOfBoundaries(boundary + 1);
                }
            }
        }
        else
        {
            if (battingTeam.getTeamPlayers().get(batsmanStrike) instanceof Bowler bowl1) {
                run = bowl1.getRunsScored();
                bowl1.setRunsScored(run + runScored);
                bowl = bowl1.getBowlPlayed();
                bowl1.setBowlPlayed(bowl + 1);
                if(runScored == 4 || runScored == 6) {
                    int boundary = bowl1.getNoOfBoundaries();
                    bowl1.setNoOfBoundaries(boundary + 1);
                }
            }
        }
        if (bowlingTeam.getTeamPlayers().get(bowlerBowling) instanceof Bowler bowl1) {
            if(runScored == 7) {
                int wicket = bowl1.getWicketsTaken();
                bowl1.setWicketsTaken(wicket+1);
            }
            run = bowl1.getRunsGiven();
            bowl1.setRunsGiven(run + runScored);
        }
    }

    public void printBattingStats(int bats) {

        int temp=0;
        for (Player player : battingTeam.getTeamPlayers()) {
            if(temp <= bats) {
                if (player instanceof Batsman bat1) {
                    System.out.println(player.getPlayerName() + "      " + bat1.getOutOrNotOut() +"       " + bat1.getRunsScored() + "         " + bat1.getBowlPlayed());
                }
                temp = temp + 1;
            }
            else {
                if (player instanceof Bowler bowl1) {
                    System.out.println(player.getPlayerName() + "      " + bowl1.getOutOrNotOut() + "        " + bowl1.getRunsScored() + "          " + bowl1.getBowlPlayed());
                }
            }
        }
    }

    public void printBowlingStats() {
        for (Player player : bowlingTeam.getTeamPlayers()) {
            if (player instanceof Bowler bowl2) {
                System.out.println(player.getPlayerName() + "     " + bowl2.getOversBowled() + "         " + bowl2.getWicketsTaken());
            }
        }
    }

    public void printRunsWickets(int over,int bowl,int totalRuns,int totalWicket,int bats) {
        System.out.println("--------------------------");
        System.out.println("NAME        WICKET    RUNS      BOWLS");
        printBattingStats(bats);
        System.out.println("---------------------------");
        System.out.println(over + "."+ bowl +"  Overs  =>  " + totalRuns + " Runs   " + totalWicket + "  Wickets");
        System.out.println("------------------------");
        System.out.println("NAME       BOWLS      WICKETS");
        printBowlingStats();
    }

    public void startInnings(int overs, int firstScore, InningStats inningStats,int bats) {

        int bowl;
        int temp;
        int totalRuns = 0;
        int totalWicket = 0;
        int wicket;
        int batsmanStrike = 0;
        int batsmanNonStrike = 1;
        int bowlerBowling = 11;

        for (int i = 1; i <= overs; i++) {
            bowlerBowling = bowlerBowling - 1;
            if (bowlerBowling == 5)
                bowlerBowling = 10;
            for (int b = 1; b <= 6; b++) {
                int ans = BallResult.predictScore().getValue();
                if (ans <= 6) {
                    updatePlayerRecord(batsmanStrike,ans,bowlerBowling,bats);
                    totalRuns = totalRuns + ans;
                    if (ans % 2 != 0) {
                        temp = batsmanStrike;
                        batsmanStrike = batsmanNonStrike;
                        batsmanNonStrike = temp;
                    }
                }
                if (ans == 7) {
                    if(batsmanStrike < bats) {
                        if (battingTeam.getTeamPlayers().get(batsmanStrike) instanceof Batsman bat1) {
                            bowl = bat1.getBowlPlayed();
                            bat1.setBowlPlayed(bowl + 1);
                            bat1.setOutOrNotOut("W");
                        }
                    }
                    else {
                        if (battingTeam.getTeamPlayers().get(batsmanStrike) instanceof Bowler bowl1) {
                            bowl = bowl1.getBowlPlayed();
                            bowl1.setBowlPlayed(bowl + 1);
                            bowl1.setOutOrNotOut("W");
                        }
                    }
                    totalWicket = totalWicket + 1;
                    if (bowlingTeam.getTeamPlayers().get(bowlerBowling) instanceof Bowler bowl1) {
                        wicket = bowl1.getWicketsTaken();
                        bowl1.setWicketsTaken(wicket + 1);
                        if(totalWicket == 10 ){
                            printRunsWickets(i,b,totalRuns,totalWicket,bats);
                            break;
                        }
                    }
                    if (batsmanStrike < batsmanNonStrike)
                        batsmanStrike = batsmanNonStrike + 1;
                    else
                        batsmanStrike = batsmanStrike + 1;
                    if (battingTeam.getTeamPlayers().get(batsmanStrike) instanceof Batsman bat1) {
                        bat1.setOutOrNotOut("*");
                    }

                }
                if(firstScore != 0 && totalRuns > firstScore) {
                    System.out.println(i + " Over => " + totalRuns + " Runs");
                    printRunsWickets(i,b,totalRuns,totalWicket,bats);
                    updateInningStats(totalRuns,totalWicket,inningStats);
                    return;
                }
                updateInningStats(totalRuns,totalWicket,inningStats);
            }
            if (bowlingTeam.getTeamPlayers().get(bowlerBowling) instanceof Bowler bowl1) {
                int over = bowl1.getOversBowled();
                bowl1.setOversBowled(over + 1);
            }
            if(totalWicket == 10)
                break;
            temp = batsmanStrike;
            batsmanStrike = batsmanNonStrike;
            batsmanNonStrike = temp;
            System.out.println(i + " Over => " + totalRuns + " Runs");
        }
        printRunsWickets(overs,0,totalRuns,totalWicket,bats);
    }
    */
}
