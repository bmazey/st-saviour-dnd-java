import java.util.Console;

public class Player {
    public String name;
    public String role;
    // For jumping over obstacles.
    public int jump;
    // For facing Mr. Mazey #Jumpscare.
    public int courage;
    // For random events.
    public int luck;

    // Asking user their stats information.
    public Player(String name, String role, int jump, int courage, int luck) {
        this.name = name;
        this.role = role;
        this.jump = jump;
        this.courage = courage;
        this.luck = luck;
    }

    // This is declaring text that the user will see.
    public void escape() {
        System.out.println(this.name + " the " + this.role + " stole the Labubu and is trying to escape Mr. Mazey!");
    }

    // This is rolling a 20 sided die and depending on where it lands it prints that.
    public static int rollD20() {
        int r = (int)(Math.random() * 20) + 1;
        Ascii.drawD20(r);
        return r;
    }

    public static int rollAdvantage() {
        int first = (int)(Math.random() * 20) + 1;
        Ascii.drawD20(first);
        int second = (int)(Math.random() * 20) + 1;
        Ascii.drawD20(second);
        return Math.max(first, second);
    }

class Ascii {
    public static void drawD20(int n) {
        System.out.println("D20: " + n);
    }
}

public static void main(String[] args) {
        Console console = new Console(System.in);
        System.out.println("ESCAPE MR. MAZEY — LABUBU OBBY! #OhNoGottaGoSaidOhNoGottaGo 🏃");

        // User input.
        System.out.print("Name: ");
        String name = console.nextLine();

        System.out.print("Role: ");
        String role = console.nextLine();

        System.out.print("Jump (1-20): ");
        int jump = console.nextInt();

        System.out.print("Courage (1-20): ");
        int courage = console.nextInt();

        System.out.print("Luck (1-20): ");
        int luck = console.nextInt();

        Player player = new Player(name, role, jump, courage, luck);

        // The game itself.
        printDramaticText("You steal the Ultra rare Labubu plush from the The #ItsGiving5Energy Classroom...");
        printDramaticText("Oh no... Mr. Mazey spots you!");
        printDramaticText("HEY! STOP RIGHT THERE!");
        printDramaticText("Your Escape Mr. Mazey Labubu Obby begins!");

        // Obstacle #1.
        printDramaticText("OBSTACLE 1: The Floor is Kombucha!");
        System.out.print("Press 'A' to roll with advantage or press 'Enter' for a normal roll: ");
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
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.luck >= 15) {
            printDramaticText("Zoom! You launch forward on the carrot at LIGHT SPEED!");
        } else {
            printDramaticText("You trip over the carrot speed pad... #Embarrassing.");
        }

        // Obstacle #3.
        printDramaticText("OBSTACLE 3: September Quiz that apparently takes place in October!");
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.luck >= 16) {
            printDramaticText("You pass the quiz and unlock the door!");
        } else {
            printDramaticText("You fail the quiz! #1Energy.");
        }

        // Obstacle #4 (Final).
        printDramaticText("OBSTACLE 4 (FINAL): ESCAPE WITH LABUBU! + Make sure you take a computer charge before you leave!");
        console.nextLine();

        roll = Player.rollD20();
        if(roll + player.courage >= 18) {
            printDramaticText("YOU ESCAPED WITH THE LABUBU! and you got a free computer charger :)");
        } else {
            printDramaticText("GAME OVER! Mr. Mazey catches you...and you get a detention :(");
        }

        System.out.println("Thanks for playing! Thank you to our sponsors: Kombucha, Carrots, September Quiz that apparently takes place in October, Free Computer Chargers, and Labubu's!");
        console.close();
    }
}