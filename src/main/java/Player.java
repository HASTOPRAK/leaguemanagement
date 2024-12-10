
/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 *
 */
public class Player {

    private String playerName;
    private int playerId;
    private String position;
    private int playerGoals;

    public Player(String playerName, int playerId, String position) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.position = position;
    }

    public String getName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPosition() {
        return position;
    }

    public int getPlayerGoals() {
        return playerGoals;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPlayerGoals(int playerGoals) {
        this.playerGoals = playerGoals;
    }

    public void displayPlayerInfo() {
        System.out.println("Player name: " + playerName);
        System.out.println("Player ID: " + playerId);
        System.out.println("Player Position: " + position);
    }

}
