import java.util.Scanner;

public class DoorRiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The door whispers: who approaches?");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Welcome, " + name + ".");
        int secret = (int) (Math.random() * 100) + 1;
        int number = 0;
        int attemps = 0;
        while (number != secret) {

            System.out.println("I demand a password to enter the dungeon.");

            number = scanner.nextInt();

            if (number > secret) {
                System.out.println("Too high! The door remains closed.");
                attemps  += 1;
            } else if (number < secret) {
                System.out.println("Too low! The door remains closed.");
                attemps += 1;
            } else if (number == secret) {
                System.out.println("The door creaks open.");
                attemps += 1;
                System.out.println("you failed " + attemps + " times you fool");
            }
        }

    }
}
