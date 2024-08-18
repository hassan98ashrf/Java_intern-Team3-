package ProjectOne;

public class PetAdoptionGame
{

    // Pet class to hold pet's information
    String name;
    int hungerLevel;
    int happinessLevel;

    // default Constructor
    public PetAdoptionGame()
    {
    }

    // Constructor for the Pet
    public PetAdoptionGame(String name) {
        this.name = name;
        this.hungerLevel = 50;      // Initial hunger level
        this.happinessLevel = 50;   // Initial happiness level
    }

    // Method to feed the pet
    public void feedPet()
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
    public void playWithPet()
    {
        if (happinessLevel < 90) {
            happinessLevel += 10;
            System.out.println(name + " is happier! Happiness level is now: " + happinessLevel);
            hungerLevel -=20;
        } else {
            System.out.println(name + " is very happy and doesn't need more play.");
        }
    }

    // Method to check the pet's status
    public void checkStatus()
    {
        System.out.println("\n--- " + name + "'s Status ---");
        System.out.println("Hunger Level: " + hungerLevel);
        System.out.println("Happiness Level: " + happinessLevel);
    }

    // Method to check if the game is over (critical conditions)
    public boolean isGameOver()
    {
        return hungerLevel <= 0 || happinessLevel <= 0;
    }
}

