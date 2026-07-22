public class DungeonGame {
    public static void main(String[] args) {
        Player hero = new Player("Daan", 20, 6);
        System.out.println(hero.name + " enters the dungeon with " + hero.health + " HP.");

        Monster zombie = new Monster("zombie", 20, 5);

        while (hero.isAlive() && zombie.isAlive()) {
            zombie.takeDamage(hero.damage);
            if (!zombie.isAlive()) {
                System.out.println("The hero is victorious!!!!!!!");
            }

            if (hero.isAlive() && zombie.isAlive()) {
                hero.takeDamage(zombie.damage);
                if (!hero.isAlive()) {
                    System.out.println("The hero is dead!! Zombie wins!!");
                }
            }
        }
    }

}

class Player {
    String name;
    int health;
    int damage;

    Player(String name, int health, int damage) {
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

    boolean isAlive() {
        return health > 0;
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

    boolean isAlive() {
        return health > 0;
    }

    void printStatus() {
        System.out.println(name + ": " + health + " HP");
    }

    void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage. He has " + health + " left remaining.");
    }
}