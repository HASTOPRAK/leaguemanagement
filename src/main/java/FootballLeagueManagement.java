
/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar
 *
 */
/*

Main class includes UI where functions are used in order:

Adding teams to the leage and adding players to them
Add matches to the fixture one by one proccess the fixture and see the league status
View and search for teams and players on the league
View previous match results and top scorer on the league


 */
import java.util.List;
import java.util.Scanner;

public class FootballLeagueManagement {

    public static void main(String[] args) {
        League league = new League();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nFootball League Management System");
            System.out.println("1. Add a Team");
            System.out.println("2. Add a Player");
            System.out.println("3. Schedule a Match");
            System.out.println("4. Process Next Match");
            System.out.println("5. View Rankings");
            System.out.println("6. View Teams and Players");
            System.out.println("7. Search for Teams or Players");
            System.out.println("8. View Match History");
            System.out.println("9. View Top Scorer");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    /* Using League class to add team*/
                    System.out.println("Enter team name: ");
                    String teamName = scanner.nextLine();
                    System.out.println("Enter team ID: ");
                    int teamID = scanner.nextInt();
                    scanner.nextLine();
                    league.addTeam(new Team(teamName, teamID));
                    System.out.println("Team added successfully.");
                    break;

                case 2:
                    /* Using League class to add player with additional TeamID information*/
                    System.out.println("Enter player name: ");
                    String playerName = scanner.nextLine();
                    System.out.println("Enter player ID: ");
                    int playerID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter player position: ");
                    String position = scanner.nextLine();
                    System.out.println("Enter team ID to add player: ");
                    int teamIdForPlayer = scanner.nextInt();
                    scanner.nextLine();
                    league.addPlayer(new Player(playerName, playerID, position), teamIdForPlayer);
                    System.out.println("Player added successfully.");
                    break;

                case 3:
                    /* Using League's queue to schedule a match between two teams*/
                    System.out.println("Enter first team ID: ");
                    int team1ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter second team ID: ");
                    int team2ID = scanner.nextInt();
                    scanner.nextLine();
                    Team team1 = league.teamMap.get(team1ID);
                    Team team2 = league.teamMap.get(team2ID);
                    if (team1 != null && team2 != null) {
                        league.scheduleMatch(team1, team2);
                        System.out.println("Match scheduled successfully.");
                    } else {
                        System.out.println("One or both teams not found.");
                    }
                    break;

                case 4:
                    /* Proccess */
                    league.processMatch();
                    System.out.println("Next match processed.");
                    break;

                case 5:
                    /* Using League's priorityQueue to fetch ranking information*/
                    List<Team> rankings = league.getRankings();
                    System.out.println("Rankings:");
                    for (Team rankTeam : rankings) {
                        System.out.println(rankTeam.teamName + " - Points: " + rankTeam.totalPoints + ", Goal Difference: " + rankTeam.goalDifference);
                    }
                    break;

                case 6:
                    /* Using League's both hashmap and list is used to fetch team and player information*/
                    System.out.println("Teams and Players:");
                    for (Team team : league.teamMap.values()) {
                        System.out.println("Team: " + team.teamName + " (ID: " + team.teamID + ")");
                        for (Player player : team.playerList) {
                            System.out.println("  Player: " + player.playerName + " (ID: " + player.playerID + ", Position: " + player.position + ")");
                        }
                    }
                    break;

                case 7:
                    /* Using League's BST to search */
                    System.out.println("Enter team or player name to search: ");
                    String name = scanner.nextLine();
                    Object result = league.teamBST.search(name);
                    if (result == null) {
                        result = league.playerBST.search(name);
                    }
                    if (result != null) {                       /*     instanceOf is used for not returning pointer but returning included info     */
                        if (result instanceof Team) {
                            Team team = (Team) result;
                            System.out.println("Team Name: " + team.teamName);
                            System.out.println("Team ID: " + team.teamID);
                            System.out.println("Points: " + team.totalPoints);
                            System.out.println("Goal Difference: " + team.goalDifference);
                            System.out.println("Players:");
                            for (Player player : team.playerList) {
                                System.out.println("  Player Name: " + player.playerName
                                        + ", ID: " + player.playerID
                                        + ", Position: " + player.position
                                        + ", Goals: " + player.playerGoals);
                            }
                        } else if (result instanceof Player) {
                            Player player = (Player) result;
                            System.out.println("Player Name: " + player.playerName);
                            System.out.println("Player ID: " + player.playerID);
                            System.out.println("Position: " + player.position);
                            System.out.println("Goals: " + player.playerGoals);
                        }
                    } else {
                        System.out.println("No team or player found with the name: " + name);
                    }
                    break;

                case 8:
                    /* Using League's stack matchHistory*/
                    System.out.println("Match History:");
                    if (!league.matchHistory.isEmpty()) {
                        for (Match match : league.matchHistory) {
                            System.out.println(match.team1.teamName + " vs " + match.team2.teamName
                                    + " | Score: " + match.team1Goals + " - " + match.team2Goals);
                        }
                    } else {
                        System.out.println("No match history available.");
                    }
                    break;

                case 9:
                    /* Using League's Player hashmap to find top scorer*/
                    Player topScorer = null;
                    int maxGoals = 0;
                    for (Player player : league.playerMap.values()) {
                        if (player.playerGoals > maxGoals) {
                            maxGoals = player.playerGoals;
                            topScorer = player;
                        }
                    }
                    if (topScorer != null) {
                        System.out.println("Top Scorer: " + topScorer.playerName + " with " + maxGoals + " goals.");
                    } else {
                        System.out.println("No players found.");
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
