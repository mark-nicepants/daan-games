public class DungeonGame {
    public static void main(String[] args) {
        Player hero = new Player("Daan", 20);
        System.out.println(hero.name + " enters the dungeon with " + hero.health + " HP.");

        Monster zombie = new Monster("zombie", 20, 5);

        hero.printStatus();
        hero.takeDamage(5);
        hero.printStatus();

        zombie.printStatus();
    
    }

}

class Player {
    String name;
    int health;

    Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    void printStatus() {
        System.out.println(name + ": " + health + " HP");
    }

    void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage. He has " + health + " left remaining.");

    }
}

class Monster {
    String name;
    int health;
    int damage;

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    void printStatus() {
        System.out.println(name + ": " + health + " HP");
    }

    void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage. He has " + health + " left remaining.");
    }
}