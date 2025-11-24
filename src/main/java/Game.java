import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {
    
        // Create Scanner for collecting user input.
        Scanner scanner = new Scanner(System.in);

        // Collect character name from user.
        System.out.print("Name: ");
        String name = scanner.nextLine();

        int r = (int)(Math.random() * 100) + 1;// make the random number
        int guesses = 1;

        printDramaticText("Welcome " + name + " to my trivia game!");
        printDramaticText("I am thinking of a number between 1 and 100. Can you guess what it is?");
        String input = scanner.nextLine();

        int guess = Integer.parseInt(input);

        while(guess != r) {
            if(guess < r) {
                printDramaticText("The number I am thinking of is higher than " + guess + " ");
            
            } else {
               printDramaticText("The number I am thinking of is lower than " + guess + " "); 
            }
            System.out.println("Try again: ");
            input = scanner.nextLine();
            guess = Integer.parseInt(input);
            guesses++;
        }

        printDramaticText("Congratualations " + name + " you guessed the right number!");
        printDramaticText("The number I was thinking of was " + r + ", it took you " + guesses + " guesses!");



      printDramaticText("But wait... a wild monster appears!");

    int difficulty = generateMonster();//find the number needed to defeat the monster

    printDramaticText("Roll a 20-sided die (1-20). Press enter to roll.");// Rolls a 20-sided die and returns the result
    scanner.nextLine();

    int roll = (int)(Math.random() * 20) + 1;
    printDramaticText("You rolled a " + roll + "!");

    if (roll >= difficulty) {
        printDramaticText("You defeated the monster! ");
    } else {
        printDramaticText("The monster overpowered you...Game over.");
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
