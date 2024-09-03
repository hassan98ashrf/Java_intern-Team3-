package ProjectThree;

import java.util.Random;
import java.util.Scanner;

public class multiplicationLearningGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int numberOfQuestion = 20;
    static int highScore ;
    static int score ;
    static int successiveCorrect ;
    static int successiveWrong ;
    static int difficultyLevel ; // Reset difficulty level for each game session
    static int userAnswer ;
    static int correctAnswer ;



    public static void startGame() {

        difficultyLevel = 1;
        successiveCorrect = 0;
        successiveWrong = 0;
        score = 0;
        enterName();

        for (int i = 1; i <= numberOfQuestion; i++) {
            askQuestion(i);

            if (userAnswer == correctAnswer) {
                calculateScoreForCorrectAnswer();

                if (successiveCorrect == 3 && difficultyLevel < 3)
                    increaseDifficulty();


                if (difficultyLevel == 3 && successiveCorrect == 3) {
                   displayWinGame(i);
                    break;
                }
            }
            else {
                calculateScoreForWrongAnswer();

                if (successiveWrong == 3) {
                    System.out.println("Game Over! You've answered 3 questions wrong in a row.\nPlease ask your teacher for extra help");
                    break;
                }
            }
        }
        displayFinalScore();
    }

    public static void enterName(){
        System.out.print("Enter your name: ");
        String name = scanner.next();
    }

    public static void askQuestion(int questionNumber){
        int firstNumber = random.nextInt(difficultyLevel * 10);
        int secondNumber = random.nextInt(difficultyLevel * 10);
        correctAnswer = firstNumber * secondNumber;
        System.out.printf("Question %d: How much is %d times %d ? " ,questionNumber,firstNumber,secondNumber);
        userAnswer = scanner.nextInt();
    }

    public static void calculateScoreForCorrectAnswer(){
        System.out.println("Correct!");
        switch (difficultyLevel) {
            case 1:
                score += 10;
                break;
            case 2:
                score += 100;
                break;
            case 3:
                score += 200;
                break;
        }
        successiveCorrect++;
        successiveWrong = 0;
    }

    public static void increaseDifficulty(){
        difficultyLevel++;
        successiveCorrect = 0;
        System.out.println("Difficulty increased to level " + difficultyLevel + "!");
    }

    public static void calculateScoreForWrongAnswer(){
        System.out.println("Incorrect! The correct answer was " + correctAnswer);
        successiveWrong++;
        successiveCorrect = 0;
    }

    public static void displayWinGame(int i){
        System.out.println("Congratulations, you've mastered the game!");
        score = score + (20 - i) * 1000;
    }


    public static void displayFinalScore(){
        if (score > highScore) {
            highScore = score;
            System.out.println("New High Score: " + score);
        } else {
            System.out.println("Your Score: " + score);
        }
    }


    public static void showHelp() {
        System.out.println("===== Help =====");
        System.out.println("This is a multiplication learning game.");
        System.out.println("You will be asked a series of multiplication questions.");
        System.out.println("Answer correctly to increase your score and difficulty level.");
        System.out.println("If you answer 3 questions correctly in a row, the difficulty increases.");
        System.out.println("If you answer 3 questions wrong in a row, the game ends.");
    }


    public static void showHighScore() {
        System.out.println("===== High Score =====");
        System.out.println("The highest score achieved so far is: " + highScore);
    }


    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Multiplication Learning Game =====");
            System.out.println("1. Start Game");
            System.out.println("2. Help");
            System.out.println("3. Show High Score");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    showHelp();
                    break;
                case 3:
                    showHighScore();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for playing! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}