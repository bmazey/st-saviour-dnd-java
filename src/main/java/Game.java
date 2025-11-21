import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        printDramaticText("ESCAPE THE MR. MAZEY — LABUBU OBBY! #OhNoGottaGoSaidOhNoGottaGo 🏃");

        // User input.
        printDramaticText("---- Name ---- ");
        String name = console.nextLine();

        printDramaticText("---- Choose your character #NotCopywrited ----");
        String role = console.nextLine();

        printDramaticText("---- Choose your skills #Carrots #MindFlayers ---- ");
        printDramaticText("---- Jump: to jump across the obstacles (1-20) ---- ");
        int jump = console.nextInt();

        printDramaticText("---- Courage: to have the courage to confront Mr. Mazey (1-20) ---- ");
        int courage = console.nextInt();

        printDramaticText("---- Luck: to have the luck to escape with the Labubu (1-20) ---- ");
        int luck = console.nextInt();

        Player player = new Player(name, role, jump, courage, luck);

        // The game itself.
        printDramaticText("You steal the ultra rare Labubu plush from the The #ItsGiving5Energy Classroom...");
        printDramaticText("Oh no... Mr. Mazey spots you!");
        printDramaticText("HEY! STOP RIGHT THERE!");
        printDramaticText("Your Escaping the Mr. Mazey Labubu Obby begins!");

        // Obstacle #1.
        printDramaticText("OBSTACLE 1: The Floor is Kombucha!");
        printDramaticText("Press 'A' to roll with advantage or press 'Enter' for a normal roll: ");
        String option = console.nextLine();

        int roll;
        if(option.toLowerCase().equals("a")) {
            roll = Player.rollAdvantage();
        } else {
            roll = Player.rollD20();
        }

        printDramaticText(player.name + " rolled a " + roll + ".");

        if(roll + player.jump >= 15) {
            printDramaticText("You leap across the Kombucha like a pro!");
        } else {
            printDramaticText("Oh no! You slip on a Kombucha platform! Mr. Mazey gets closer! #TooFermented.");
        }

        // Obstacle #2.
        printDramaticText("OBSTACLE 2: Carrot Speed Pads Ahead!");
        printDramaticText("Press 'A' to roll with advantage or press 'Enter' for a normal roll: ");
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.luck >= 15) {
            printDramaticText("Zoom! You launch forward on the carrot at LIGHT SPEED!");
        } else {
            printDramaticText("You trip over the carrot speed pad... #Embarrassing.");
        }

        // Obstacle #3.
        printDramaticText("OBSTACLE 3: September Quiz that apparently takes place in October!");
        printDramaticText("Press 'A' to roll with advantage or press 'Enter' for a normal roll: ");
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.luck >= 16) {
            printDramaticText("You pass the quiz and unlock the door!");
        } else {
            printDramaticText("You fail the quiz! #1Energy.");
        }

        // Obstacle #4 (Final).
        printDramaticText("OBSTACLE 4 (FINAL): ESCAPE WITH LABUBU! + Make sure you take a computer charger before you leave!");
        printDramaticText("Press 'A' to roll with advantage or press 'Enter' for a normal roll: ");
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.courage >= 18) {
            printDramaticText("YOU ESCAPED WITH THE LABUBU! and you got a free computer charger :)");
        } else {
            printDramaticText("GAME OVER! Mr. Mazey catches you...and you get a detention :(");
        }

        printDramaticText("Thanks for playing! Thank you to our sponsors: Kombucha, Carrots, September Quiz that apparently takes place in October, Free Computer Chargers, and Labubu's!");
        console.close();
    }
        
    public static void printDramaticText(String text) {
        // Delay in milliseconds
        int delay = 80;

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
