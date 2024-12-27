/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar 
 *
 */
class Player {
    String playerName;
    int playerID;
    String position;
    int playerGoals;

    Player(String playerName, int playerID, String position) {
        this.playerName = playerName;
        this.playerID = playerID;
        this.position = position;
        this.playerGoals = 0;
    }

    void updatePlayerGoals(int goals) {
        this.playerGoals += goals;
    }
}