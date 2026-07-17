import java.util.Scanner; 

public class DoorRiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        

        System.out.print("The door whispers: who approaches?");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Welcome, " + name + ".");
        
        int secret = 37;
        System.out.println("I demand a password to enter the dungeon.");
        int number = scanner.nextInt();
        if (number > 37) {
            System.out.println("Too high! The door remains closed.");
        } else if (number < 37) {
            System.out.println("Too low! The door remains closed.");
        } else if (number == 37) {
            System.out.println("The door creaks open.");
        } 
    }
}
