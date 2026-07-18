public class DungeonMap {
    public static void main(String[] args) {
        printTitle();
        greet("daan");
        greet("mark");
        char[] hallway = {'#', '.', '.', '.', '.', '#'};
        for (int i = 0; i < hallway.length; i++) {
            System.out.print(hallway[i]);
        }
        System.out.println();

    }

    static void printTitle() {
        System.out.println("=============");
        System.out.println(" \\--------/");
        System.out.println("  | jugo | ");
        System.out.println("--\\------/---");
    }

    static void greet(String name) {
        System.out.println("Welcome, " + name + ".");
    }
}
