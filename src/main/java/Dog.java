public class Dog {
    public String name;
    public String breed;
    public int legs = 4;
    public int eyes = 2;
    public boolean tail = true;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void bark() {
        System.out.println(this.name + " the " + this.breed + " barks ... woof! woof!");
    }

    public void terribleAccident() {
        System.out.println(this.name + " the " + this.breed + " was in a terrible accident!");
        this.legs -= 1;
    }
}
