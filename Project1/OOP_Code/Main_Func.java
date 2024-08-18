package ProjectOne;

import java.util.Scanner;

public class Main_Func
{

    // Main method
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PetAdoptionGame myPet = new PetAdoptionGame();
        boolean gameOver = false;

        System.out.println("Welcome to the Pet Adoption Game!");

        // Game loop
        while (!gameOver) {
            System.out.println("\nMenu:");
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
                    if (myPet.name == null) {
                        System.out.print("Enter the name of your pet: ");
                        String petName = scanner.nextLine();
                        myPet = new PetAdoptionGame(petName);
                        System.out.println("Congratulations! You have adopted " + myPet.name + ".");
                        myPet.checkStatus();
                    } else {
                        System.out.println("You have already adopted a pet: " + myPet.name + ".");
                    }
                    break;

                case 2:
                    if (myPet.name != null) {
                        myPet.feedPet();
                    } else {
                        System.out.println("Please adopt a pet first.");
                    }
                    break;

                case 3:
                    if (myPet.name != null) {
                        myPet.playWithPet();
                    } else {
                        System.out.println("Please adopt a pet first.");
                    }
                    break;

                case 4:
                    if (myPet.name != null) {
                        myPet.checkStatus();
                    } else {
                        System.out.println("Please adopt a pet first.");
                    }
                    break;

                case 5:
                    if (myPet.name != null) {
                        System.out.println("Game Over! Here's your pet's final status:");
                        myPet.checkStatus();
                    } else {
                        System.out.println("Game Over! No pet was adopted.");
                    }
                    gameOver = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }

            // End the game if the pet's hunger or happiness levels drop to critical levels
            if (myPet.name != null && myPet.isGameOver()) {
                System.out.println("Your pet is in critical condition. The game is over.");
                myPet.checkStatus();
                gameOver = true;
            }
        }
        System.out.println("Thank you for playing the Pet Adoption Game!");
    }
}




