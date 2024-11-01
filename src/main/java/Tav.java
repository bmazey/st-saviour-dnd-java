
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
    private boolean guidance;
    private boolean bardicInspiration;

    // Constructor method.
    public Tav(String name, String role) {
        // Randomly generate stat array.
        this.name = name;
        this.role = role;
    }

    // Constructor method.
    public Tav(String name, String role, int str, int dex, int con, int cha, int intel, int wis) {
        // Ensure provided stats add up.
        this.name = name;
        this.role = role;

        this.strength = str;
        this.dexterity = dex;
        this.constitution = con;
        this.charisma = cha;
        this.intelligence = intel;
        this.wisdom = wis;
    }

    public int constitutionSavingThrow() {
        return 0;
    }
}