public class DungeonGame {
    public static void main(String[] args) {
        Player hero = new Player("Daan", 20);
        System.out.println(hero.name + " enters the dungeon with " + hero.health + " HP.");
    }
}

class Player {
    String name;
    int health;

    Player(String startName, int startHealth) {
        name = startName;
        health = startHealth;
    }
}
