
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author 200316008 Yusuf Hastoprak 200316003 Irem Boyalioglu
 *
 */
public class Team {

    private String name;
    private int teamId;
    private LinkedList<Player> players;
    private int totalPoint;
    private int teamGoals;
    
    
    public String getName(){
        return name;
    }
    
    public int getTeamId(){
        return teamId;
    }
    
    public int getTotalPoint(){
        return totalPoint;
    }
    
    public int getTeamGoals(){
        return teamGoals;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTeamId(int teamId){
        this.teamId = teamId;
    }
    
    public void setTotalPoint(int totalPoint){
        this.totalPoint = totalPoint;
    }
    
    public void setTeamGoals(int teamGoals){
        this.teamGoals = teamGoals;
    }
    

    public Team(String name, int teamId) {
        this.name = name;
        this.teamId = teamId;
        this.players = new LinkedList<Player>();
        this.teamGoals = 0;
        this.totalPoint = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void displayTeamInfo() {
        System.out.println("Team name: " + name);
        System.out.println("Team ID: " + teamId);
        System.out.println("Players:");

        if (players.isEmpty()) {
            System.out.println("There are no players in this team.");
        } else {
            players.forEach(player -> {
                player.displayPlayerInfo();
                System.out.println("-----------------------");
            });
        }
    }
    
    public void teamMenu(Team team){
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("You are managing " + team.name);

        while (running) {
            System.out.println("\n--- Actions ---");
            System.out.println("1. Add Player");
            System.out.println("2. Show Team Information");
            System.out.println("3. Exit");
            System.out.println("Please enter your choice:  ");
            int choice = scanner.nextInt();

            
            switch (choice) {
                case 1:
                    
                    System.out.println("Player name: ");
                    scanner.nextLine();
                    String playerName = scanner.nextLine();
                    System.out.println("Player ID: ");
                    int playerId = scanner.nextInt();
                    System.out.println("Player Position: ");
                    scanner.nextLine();
                    String position = scanner.nextLine();

                    Player newPlayer = new Player(playerName, playerId, position); // !!!!!!!!!!
                    team.addPlayer(newPlayer);
                    System.out.println("The player has been successfully added!");
                    break;

                case 2:
                    team.displayTeamInfo(); // if else kullanmazsak sanırım boşsa gözükmüyor  eklenmiyor da case 2 hata veriyor
                    break;

                case 3:
                    System.out.println("Logging out of the menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
        
        scanner.close();
        
    }

}
