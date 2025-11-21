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
}