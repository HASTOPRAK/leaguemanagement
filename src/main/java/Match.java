
/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar
 *
 */


/* 

This class is only used for simulating matches and giving scores

*/
import java.util.Random;

class Match {

    Team team1;
    Team team2;
    int team1Goals;
    int team2Goals;

    Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    void simulateMatch() {
        Random random = new Random();
        this.team1Goals = random.nextInt(5); 
        this.team2Goals = random.nextInt(5);

        /* Goals are randomized for both teams */
        
        for (int i = 0; i < team1Goals; i++) {
            if (!team1.playerList.isEmpty()) {
                Player scorer = team1.playerList.get(random.nextInt(team1.playerList.size()));
                scorer.updatePlayerGoals(1);
            }
        }

        
        for (int i = 0; i < team2Goals; i++) {
            if (!team2.playerList.isEmpty()) {
                Player scorer = team2.playerList.get(random.nextInt(team2.playerList.size()));
                scorer.updatePlayerGoals(1);
            }
        }

        /* Points are given depending on the result */
        
        if (team1Goals > team2Goals) {
            team1.totalPoints += 3;
        } else if (team2Goals > team1Goals) {
            team2.totalPoints += 3;
        } else {
            team1.totalPoints += 1;
            team2.totalPoints += 1;
        }
        team1.goalDifference += (team1Goals - team2Goals);
        team2.goalDifference += (team2Goals - team1Goals);
    }
}
