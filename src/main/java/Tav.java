import java.util.Random;

public class Tav {
    // Character name.
    private String name;

    // Character class.
    private String role;

    // Character stats.
    private int strength;
    private int dexterity;
    private int constitution;
    private int charisma;
    private int intelligence;
    private int wisdom;

    // Roll modifiers.
    private boolean advantage;
    private boolean disadvantage;
    private boolean bardicInspiration;
    private boolean guidance;

    // Constructor method.
    public Tav(String name, String role) {
        this.name = name;
        this.role = role;

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

    public int statBonus(String stat) {
        return 0;
    }

    public int constitutionSavingThrow(int requirement) {
        return 0;
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