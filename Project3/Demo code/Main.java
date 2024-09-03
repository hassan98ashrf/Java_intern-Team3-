package project_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int highScore = 0;
    static String playerName = null;
    static int chosenOption = 0;
    static int wrongTimes = 0;
    static int rightTimes = 0;
    static int level = 1;
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        game_initiate();


        while (wrongTimes < 3 && rightTimes < 3 && level < 3) {
            playGame();
        }

        System.out.println("Thank you for playing, " + playerName + "!");
        showResults();
    }

    public static void game_initiate() {
        System.out.println("Welcome to the Multiplication Learning Game :) ");
        options();
    }

    public static void options() {
        System.out.print("1 - Start Game\n2 - Help\n3 - Show High Score\n4 - Exit\n");
        System.out.println("================================================================");
        System.out.print("Please Choose From option 1 - 4 : ");
        chosenOption = sc.nextInt();
        sc.nextLine(); // Consume newline character
        handleOption(chosenOption);
    }

    public static void handleOption(int option) {
        switch (option) {
            case 1:
                System.out.print("\nPlease Enter Your Name :  ");
                playerName = sc.nextLine();
//                sc.nextLine();
                System.out.println("Welcome, " + playerName + "!");
                playGame();
                break;
            case 2:
                System.out.println("Help content :)");
                break;
            case 3:
                showResults();
                break;
            case 4:
                System.out.println("Exiting the game...");
                System.exit(0); // Exit the program
            default:
                System.out.println("Invalid option. Please choose from 1-4.");
                options(); // Redisplay options if invalid input
        }
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        return random.ints(min, max + 1) // Include max value
                .findFirst()
                .getAsInt();
    }

    public static int generateQuestion() {
        int num1 = getRandomNumberUsingInts(1, level * 10);
        int num2 = getRandomNumberUsingInts(1, level * 10);
        System.out.println("What is " + num1 + " x " + num2 + "? ");
        return num1 * num2;
    }

    public static void playGame() {

        int correctAnswer = generateQuestion();
        int userAnswer = sc.nextInt();
        sc.nextLine();

        if (userAnswer == correctAnswer) {
            System.out.println("Correct!");
            rightTimes++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
            wrongTimes++;
        }

        if (rightTimes >= 3) {
            level++;
            System.out.println("Congratulations! You've advanced to level " + level + ".");
        } else if (wrongTimes >= 3) {
            System.out.println("Game over! You didn't reach the required score.");
        }
    }

    public static void showResults() {
        System.out.println("Your final score:");
        System.out.println("Correct answers: " + rightTimes);
        System.out.println("Incorrect answers: " + wrongTimes);
        System.out.println("Accuracy: " + ((double) rightTimes / (rightTimes + wrongTimes)) * 100 + "%");

        // Check if new high score
        if (rightTimes > highScore) {
            highScore = rightTimes;
            System.out.println("Congratulations! You achieved a new high score of " + highScore + ".");
        } else {
            System.out.println("The current high score is " + highScore + ".");
        }
    }
}