/**
 *
 * @author
 * 200316008 Yusuf Hastoprak
 * 200316003 Irem Boyalioglu
 * 200316030 Huseyin Ozdamar
 *
 */
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class League {
    /* 
    
    To satisfy the requirements these data structures are used;
    
    Heap                --> League Ranking
    
    Queue               --> To schedule match
    
    Stack               --> To store previous matches
    
    Hash map            --> Store teams and players
    
    Binary Search Tree  --> Search in teams and players
    
    */
    
    
    PriorityQueue<Team> rankings;
    Queue<Match> matchSchedule;
    Stack<Match> matchHistory;
    HashMap<Integer, Team> teamMap;
    HashMap<Integer, Player> playerMap;
    BST teamBST;
    BST playerBST;

    League() {
        
        /* PriorityQueue feature is used as Min Heap*/
        
        rankings = new PriorityQueue<>((t1, t2) -> {
            if (t1.totalPoints != t2.totalPoints) {
                return t2.totalPoints - t1.totalPoints;
            }
            return t2.goalDifference - t1.goalDifference;
        });
        matchSchedule = new LinkedList<>();
        matchHistory = new Stack<>();
        teamMap = new HashMap<>();
        playerMap = new HashMap<>();
        teamBST = new BST();
        playerBST = new BST();
    }

    void addTeam(Team team) {
        teamMap.put(team.teamID, team);
        teamBST.insert(team.teamName, team);
        rankings.add(team);
    }

    void addPlayer(Player player, int teamID) {
        Team team = teamMap.get(teamID);
        if (team != null) {
            team.addPlayer(player);
            playerMap.put(player.playerID, player);
            playerBST.insert(player.playerName, player);
        }
    }

    void scheduleMatch(Team team1, Team team2) {
        matchSchedule.add(new Match(team1, team2));
    }

    void processMatch() {
        if (!matchSchedule.isEmpty()) {
            Match match = matchSchedule.poll();
            match.simulateMatch();
            matchHistory.push(match);
            rankings.remove(match.team1);
            rankings.remove(match.team2);
            rankings.add(match.team1);
            rankings.add(match.team2);
        }
    }

    List<Team> getRankings() {
        return new ArrayList<>(rankings);
    }
}