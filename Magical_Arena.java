import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) 
    {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }
    public int getAttack() {
        return attack;
    }

    private int rollDie()  // Method to simulate rolling a six-sided die
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Generates a number between 1 and 6
    }

    public void attack(Player opponent)  // Method to perform an attack on another player
    {
        int attackRoll = rollDie();
        int defendRoll = opponent.rollDie();

        int attackDamage = this.attack * attackRoll;
        int defendPower = opponent.getStrength() * defendRoll;

        int netDamage = Math.max(0, attackDamage - defendPower);
        opponent.setHealth(Math.max(0, opponent.getHealth() - netDamage));

        // Print the results for this turn with player names
        System.out.printf("%s rolls %d (Attack: %s), %s rolls %d (Defense: %s)%n",
                          this.name, attackRoll, this.name, opponent.getName(), defendRoll, opponent.getName());
        System.out.printf("Net Damage to %s: %d | %s's Remaining Health: %d%n%n", 
                          opponent.getName(), netDamage, opponent.getName(), opponent.getHealth());
    }
  
    public boolean isAlive() // Check if the player is still alive
    {
        return this.health > 0;
    }
}

public class MagicalArena 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded player names
        String playerAName = "Player A";
        String playerBName = "Player B";

        // Getting user input for Player A
        System.out.println("Enter stats for Player A:");
        System.out.print("Health: ");
        int playerAHealth = scanner.nextInt();
        System.out.print("Strength: ");
        int playerAStrength = scanner.nextInt();
        System.out.print("Attack: ");
        int playerAAttack = scanner.nextInt();

        // Getting user input for Player B
        System.out.println("Enter stats for Player B:");
        System.out.print("Health: ");
        int playerBHealth = scanner.nextInt();
        System.out.print("Strength: ");
        int playerBStrength = scanner.nextInt();
        System.out.print("Attack: ");
        int playerBAttack = scanner.nextInt();

        // Create the players with the user input stats and hardcoded names
        Player playerA = new Player(playerAName, playerAHealth, playerAStrength, playerAAttack);
        Player playerB = new Player(playerBName, playerBHealth, playerBStrength, playerBAttack);

        System.out.println("\nThe match begins!\n");

        // Simulate the match
        while (playerA.isAlive() && playerB.isAlive()) 
        {
            if (playerA.getHealth() <= playerB.getHealth()) 
            {
                System.out.println(playerA.getName() + " attacks!");
                playerA.attack(playerB);
                if (!playerB.isAlive()) 
                {
                    System.out.println(playerB.getName() + " has been defeated! " + playerA.getName() + " wins!");
                    break;
                }

                System.out.println(playerB.getName() + " attacks!");
                playerB.attack(playerA);
                if (!playerA.isAlive()) 
                {
                    System.out.println(playerA.getName() + " has been defeated! " + playerB.getName() + " wins!");
                    break;
                }
            } 
            else 
            {
                System.out.println(playerB.getName() + " attacks!");
                playerB.attack(playerA);
                if (!playerA.isAlive()) 
                {
                    System.out.println(playerA.getName() + " has been defeated! " + playerB.getName() + " wins!");
                    break;
                }

                System.out.println(playerA.getName() + " attacks!");
                playerA.attack(playerB);
                if (!playerB.isAlive()) 
                {
                    System.out.println(playerB.getName() + " has been defeated! " + playerA.getName() + " wins!");
                    break;
                }
            }
            System.out.println("-----");
        }

        System.out.println("Game over.");
        scanner.close();
    }
}
