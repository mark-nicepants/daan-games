import java.util.Scanner; 

public class DoorRiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("The door whispers: who approaches?");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Welcome, " + name + ".");
    }
}
