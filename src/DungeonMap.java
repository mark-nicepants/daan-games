public class DungeonMap {
    public static void main(String[] args) {
        printTitle();
        greet("daan");
        greet("mark");
        int playerRow = 2;
        int playerCol = 1;

        char[][] map = {
                { '#', '#', '#', '#', '#', },
                { '#', '.', '.', '.', '#', },
                { '#', '.', '#', '.', '#', },
                { '#', '.', '.', '.', '#', },
                { '#', '#', '#', '#', '#', },
        };
        printMap(map, playerRow, playerCol);
    }

    static void printMap(char[][] map, int playerRow, int playerCol) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (r == playerRow && c == playerCol) {
                    System.out.print('@');
                } else {
                    System.out.print(map[r][c]);
                }
            }
            System.out.println();
        }
    }

    static void printTitle() {
        System.out.println("=============");
        System.out.println(" \\--------/");
        System.out.println("  | JUGO | ");
        System.out.println("--\\------/---");
    }

    static void greet(String name) {
        System.out.println("Welcome, " + name + ".");
    }
}
