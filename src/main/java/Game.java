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
        
        // Create character by collecting user input (name + role)
        Tav tav = new Tav(name, role);

        // Print character sheet.
        tav.printCharacterSheet();

        // Start the adventure.
        printDramaticText("Our adventure begins in a shady tavern ...");
        
        int wins = 0;
        boolean alive = true;

        while(alive) {
            // Start the encounter
            System.out.println("");
            printDramaticText("A monster approaches!");

            // Generate a dungeon monster.
            int requirement = generateMonster();

            printDramaticText("Press A for advantage, G for guidance, & Enter to roll:");

            String buff = scanner.nextLine();
            int result = tav.roll(buff);

            if(result == 20) {
                System.out.println();
                printDramaticText("     CRITICAL SUCCESS");
                System.out.println();
            }

            if(result == 1) {
                System.out.println();
                printDramaticText("     CRITICAL FAILURE");
                System.out.println();
                printDramaticText("     G A M E   O V E R !");
                System.out.println();
                alive = false;
            }

            if(result < requirement) {
                System.out.println();
                printDramaticText("You rolled " + result + ", you needed " + requirement + " ...");
                System.out.println();
                printDramaticText("     G A M E   O V E R !");
                System.out.println();
                alive = false;
            } else {
                System.out.println();
                printDramaticText("You rolled " + result + ", you needed " + requirement + " ... well done!");
                System.out.println();
            }

            wins++;

            if(wins == 3) {
                System.out.println("");
                printDramaticText(tav.name + " the " + tav.role + " has completed the campaign!");
                System.out.println();
                printDramaticText("               {  fin  }");
                System.out.println();
                break;
            }
        } 
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
            System.out.println("++++++++++ " + mask + " DISGUISED MIMIC " + mask + " ++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  12           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 12;
        }
        if(r == 6) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + "  +++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 18;
        }
        return -1;
    } 
}
