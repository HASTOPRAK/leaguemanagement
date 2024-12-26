/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar
 *
 */

/* 

Linked list is used to store player information in team

*/

import java.util.LinkedList;
class Team {
    String teamName;
    int teamID;
    LinkedList<Player> playerList;
    int totalPoints;
    int goalDifference;

    Team(String teamName, int teamID) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.playerList = new LinkedList<>();
        this.totalPoints = 0;
        this.goalDifference = 0;
    }

    void addPlayer(Player player) {
        playerList.add(player);
    }

    void removePlayer(int playerID) {
        playerList.removeIf(player -> player.playerID == playerID);
    }

    void updatePlayer(Player updatedPlayer) {
        for (Player player : playerList) {
            if (player.playerID == updatedPlayer.playerID) {
                player.playerName = updatedPlayer.playerName;
                player.position = updatedPlayer.position;
                player.playerGoals = updatedPlayer.playerGoals;
                break;
            }
        }
    }
}