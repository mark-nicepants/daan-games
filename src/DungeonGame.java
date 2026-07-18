public class DungeonGame {
    public static void main(String[] args) {
        Player hero = new Player("Daan", 20);
        System.out.println(hero.name + " enters the dungeon with " + hero.health + " HP.");

        hero.printStatus();
        hero.takeDamage(5);
        hero.printStatus();
    }

}

class Player {
    String name;
    int health;

    Player(String startName, int startHealth) {
        name = startName;
        health = startHealth;
    }

    void printStatus() {
        System.out.println(name + ": " + health + "HP");
    }

    void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage. He has " + health + " left remaining.");

    }
}
