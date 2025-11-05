public class Player {

    public String name;
    public String role;

    public int dexterity;
    public int charisma;
    // TODO Add rest of the stats.

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void attack() {
        System.out.println(this.name + " the " + this.role + " attacks!");
    }
    
}
