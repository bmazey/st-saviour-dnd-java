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
        if(first > second) {
            return first;
        } else {
            return second;
        }
    }

    
}
