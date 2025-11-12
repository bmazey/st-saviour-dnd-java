import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

        // Create Scanner for collecting user input.
        Scanner scanner = new Scanner(System.in);

        // Collect character name from user.
        System.out.print("Name: ");
        String name = scanner.nextLine();

        // Collect character role from user.
        System.out.print("Role: ");
        String role = scanner.nextLine();

        Player player = new Player(name, role);
        printDramaticText("Welcome " + player.name + " the " + player.role + " to Bludgeons & Flagons!");
        printDramaticText("Our adventure begins in a shady tavern ...");

        System.out.print("Press A to roll with advantage or press Enter to roll a D20. ");
        String option = scanner.nextLine();
        if(option.toLowerCase().equals("a")) {
            int roll = Player.rollAdvantage();
            printDramaticText(player.name + " rolled a " + roll + ".");
        } else {
            int roll = Player.rollD20();
            printDramaticText(player.name + " rolled a " + roll + ".");
        }

        // Player player1 = new Player("Everett", "Wizard");
        // player1.attack();

        // System.out.println("Your name is " + name + " and your role is " + role + ".");
        
        // Start the adventure.
        // printDramaticText("Our adventure begins in a shady tavern ...");

        // Roll a d20
        // System.out.print("Press Enter to roll a d20.");
        // scanner.nextLine();

        // Range: [1, 20]
        // for(int i = 0; i < 10000; i++) {
        //     int roll = (int)(Math.random() * 20) + 1;
        //     if(roll > 20 || roll < 1) {
        //         System.out.println("The range is incorrect!");
        //     }
        // }

        // Ascii.drawD20(roll);

        // TODO Continue ...
    }
        
    public static void printDramaticText(String text) {
        // Delay in milliseconds
        int delay = 100;

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Draws a monster and returns an int which represents the difficulty of roll required.
    public static int generateMonster() {
        int r = (int)(Math.random() * 6) + 1;
        if(r == 1 || r == 2 || r == 3) {
            String zombie = Character.toString(0x1F9DF);
            System.out.println("++++++++ " + zombie + " A HORDE OF ZOMBIES " + zombie + " ++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  8            +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 8;
        }
        if(r == 4 || r == 5) {
            String mask = Character.toString(0x1F3AD);
            System.out.println("++++++++++ " + mask + " DISGUISED MIMIC " + mask + " +++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  12           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 12;
        }
        if(r == 6) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + " ++++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 18;
        }
        return -1;
    } 
}
