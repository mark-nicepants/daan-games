public class DungeonMap {
    public static void main(String[] args) {
        printTitle();
        greet("daan");
        greet("mark");

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
