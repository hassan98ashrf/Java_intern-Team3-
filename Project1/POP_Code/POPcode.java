package ProjectOne;

import java.util.Scanner;

public class POPcode {

    static String name = null ;
    static int hungerLevel;
    static int happinessLevel;


    // Method to feed the pet
    public static void feedPet()
    {
        if (hungerLevel < 90) {
            hungerLevel += 10;
            System.out.println(name + " has been fed. Hunger level is now: " + hungerLevel);
            happinessLevel -=10;
        } else {
            System.out.println(name + " is full and cannot eat more.");
        }
    }

    // Method to play with the pet
    public static void playWithPet()
    {
        if (happinessLevel < 90) {
            happinessLevel += 10;
            System.out.println(name + " is happier! Happiness level is now: " + happinessLevel);
            hungerLevel -=20;
        } else {
            System.out.println(name + " is very happy and doesn't need more play.");
        }
    }


    // Method to check if the game is over (critical conditions)
    public static boolean isGameOver()
    {
        return hungerLevel <= 0 || happinessLevel <= 0;
    }



    public static void checkStatus()
    {
        System.out.println("\n--- " + name + "'s Status ---");
        System.out.println("Hunger Level: " + hungerLevel);
        System.out.println("Happiness Level: " + happinessLevel);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;

        System.out.println("Welcome to the Pet Adoption Game!");

         while(!gameOver)
         { System.out.println("\nMenu:");
             System.out.println("1. Adopt a Pet");
             System.out.println("2. Feed your Pet");
             System.out.println("3. Play with your Pet");
             System.out.println("4. Check your Pet's Status");
             System.out.println("5. End the Game");
             System.out.print("Enter your choice (1-5): ");
             int choice = scanner.nextInt();
             scanner.nextLine();

             switch (choice) {
                 case 1:
                     if (name == null) {
                         System.out.print("Enter the name of your pet: ");
                         name = scanner.nextLine();
                         System.out.println("Congratulations! You have adopted " + name + ".");
                         happinessLevel = 50 ;
                         hungerLevel = 50 ;
                         checkStatus();
                     } else {
                         System.out.println("You have already adopted a pet: " + name + ".");
                     }
                     break;

                 case 2:
                     if (name != null) {
                         feedPet();
                     } else {
                         System.out.println("Please adopt a pet first.");
                     }
                     break;

                 case 3:
                     if (name != null) {
                         playWithPet();
                     } else {
                         System.out.println("Please adopt a pet first.");
                     }
                     break;

                 case 4:
                     if (name != null) {
                         checkStatus();
                     } else {
                         System.out.println("Please adopt a pet first.");
                     }
                     break;

                 case 5:
                     if (name != null) {
                         System.out.println("Game Over! Here's your pet's final status:");
                         checkStatus();
                     } else {
                         System.out.println("Game Over! No pet was adopted.");
                     }
                     gameOver = true;
                     break;

                 default:
                     System.out.println("Invalid choice! Please select a valid option.");
                     break;
             }
             if (name != null && isGameOver())
             {
                 System.out.println("Your pet is in critical condition. The game is over.");
                 checkStatus();
                 gameOver = true;
             }
         }
        System.out.println("Thank you for playing the Pet Adoption Game!");
    }
}
