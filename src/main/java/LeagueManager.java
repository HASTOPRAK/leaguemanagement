
import java.util.HashMap;

/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 *
 */
public class LeagueManager {
    private HashMap<String, Team> teamTable;

    public LeagueManager() {
        teamTable = new HashMap<>();
    }

    // Add a team to the hash table
    public void addTeam(String teamId, Team team) {
        teamTable.put(teamId, team);
    }

    // Display all teams in the hash table
    public void displayTeams() {
        System.out.println("Teams in the league:");
        for (String teamId : teamTable.keySet()) {
            Team team = teamTable.get(teamId);
            System.out.println("ID: " + teamId + ", Name: " + team.getName());
        }
    }
}