import java.util.Random;

public class Tav {
    // Character name.
    public String name;

    // Character class.
    public String role;

    // Character level.
    public int level;

    // Character stats.
    private int strength;
    private int dexterity;
    private int constitution;
    private int charisma;
    private int intelligence;
    private int wisdom;

    // Constructor method.
    public Tav(String name, String role) {
        this.name = name;
        this.role = role;
        this.level = 1;

        // Randomly assign stats from shuffled stat array.
        int[] stats = new int[]{15, 14, 13, 12, 10, 8};
        shuffle(stats);

        this.strength     = stats[0];
        this.dexterity    = stats[1];
        this.constitution = stats[2];
        this.charisma     = stats[3];
        this.intelligence = stats[4];
        this.wisdom       = stats[5];
    }

    // Print character sheet!
    public void printCharacterSheet() {
        // Emojis.
        String fire = Character.toString(0x1F525);
        String sword = Character.toString(0x2694);

        System.out.println("======= " + fire + " BLUDGEONS & FLAGONS " + fire + " =======");
        System.out.println("Name:   " + this.name);
        System.out.println("Role:   " + this.role);
        System.out.println("Level:  " + this.level);
        System.out.println("---------- " + sword + " CHARACTER STATS " + sword + " ----------");
        System.out.println("Strength        " + this.strength);
        System.out.println("Dexterity       " + this.dexterity);
        System.out.println("Constitution    " + this.constitution);
        System.out.println("Charisma        " + this.charisma);
        System.out.println("Intelligence    " + this.intelligence);
        System.out.println("Wisdom          " + this.wisdom);
        System.out.println("-----------------------------------------");
    }

    public int roll(String input) {
        if (input.equals("a")) {
            int first = rollD20();
            Ascii.drawD20(first);

            int second = rollD20();
            Ascii.drawD20(second);

            if(first > second) {
                return first;
            } else {
                return second;
            }
        }
        if (input.equals("g")) {
            int roll = rollD20();
            int guidance = rollD6();

            Ascii.drawD20(roll);
            Ascii.drawD4(guidance);
            return roll + guidance;
        } else {
            int roll = rollD20();
            Ascii.drawD20(roll);
            return roll;
        }
    }

    public int rollD20() {
        return (int)(Math.random() * 20) + 1;
    }

    public int rollD6() {
        return (int)(Math.random() * 6) + 1;
    }

    public int rollD4() {
        return (int)(Math.random() * 4) + 1;
    }

    // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    private void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            
            // Swap elements
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}