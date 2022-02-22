package com.tekion.cricketmatch.temp;


public class Match {
/*
    private String matchId;
    private final Team team1 = new Team();
    private final Team team2 = new Team();
    private final InningStats firstInningsStats = new InningStats();
    private final InningStats secondInningsStats = new InningStats();


    private final Inning innings1 = new Inning(this.team1, this.team2);
    private final Inning innings2 = new Inning(this.team2, this.team1);

    public void startMatch() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Match ID : ");
        matchId = input.readLine();
        System.out.print("Enter FIRST team Name : ");
        String firstTeamName = input.readLine();
        team1.setTeamName(firstTeamName);
        System.out.print("Enter SECOND team Name : ");
        String secondTeamName = input.readLine();
        team2.setTeamName(secondTeamName);
        System.out.print("How Many Overs that has to be bowled per innings : ");
        int overs = Integer.parseInt(input.readLine());
        System.out.print("How many batsman you want in the Team : ");
        int bats = Integer.parseInt(input.readLine());
        System.out.println("---------------- TOSS TIME ----------------------------");
        System.out.print(firstTeamName + " has the coin 'Press H for HEAD and T for TAIL' : ");
        String toss = input.readLine();
        int tossResult = Toss.doToss().getValue();
        if (toss.equals("H") && tossResult == 0) {
            System.out.println(secondTeamName + " won the toss What you want to choose BAT/BALL ");
            String choose = input.readLine();
            if (choose.equals("BAT") || choose.equals("Bat")) {
                this.team1.addBatsman(bats);
                this.team1.addBowler(11 - bats);
                this.team2.addBatsman(bats);
                this.team2.addBowler(11 - bats);
            } else {
                this.team2.addBatsman(bats);
                this.team2.addBowler(11 - bats);
                this.team1.addBatsman(bats);
                this.team1.addBowler(11 - bats);
            }
        } else {
            System.out.println(firstTeamName + " won the toss and elected to BAT first");
            this.team1.addBatsman(bats);
            this.team1.addBowler(11 - bats);
            this.team2.addBatsman(bats);
            this.team2.addBowler(11 - bats);
        }

        System.out.println("------------------- FIRST INNINGS -----------------");
        int totalRun = 0;
        innings1.startInnings(overs, totalRun, firstInningsStats, bats);

        System.out.println("------------------- SECOND INNINGS ----------------");
        innings2.startInnings(overs, firstInningsStats.getInningScore(), secondInningsStats, bats);

        System.out.println("------------------------------");
        if (secondInningsStats.getInningScore() > firstInningsStats.getInningScore())
            System.out.println(secondTeamName + " won the Match");
        else if (firstInningsStats.getInningScore() > secondInningsStats.getInningScore())
            System.out.println(firstTeamName + " won the Match");
        else System.out.println("MATCH DRAW");
    }

 */
}