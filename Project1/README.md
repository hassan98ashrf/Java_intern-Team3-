# Pet Adoption Game

## Overview

The **Pet Adoption Game** is a console-based application written in Java that simulates the experience of adopting and taking care of a virtual pet. Users can interact with their pet by adopting it, feeding it, playing with it, and checking its status. The game tracks the pet's hunger and happiness levels, and the game will end if either of these levels drop to critical values.

This project showcases both Procedural Programming (POP) and Object-Oriented Programming (OOP) principles. We later created a web page simulation of the game using JavaScript and HTML, and implemented automated tests with Selenium.

## Features

1. **Adopt a Pet**: Start the game by adopting a pet.
2. **Feed the Pet**: Increase the pet's hunger level by feeding it.
3. **Play with the Pet**: Increase the pet's happiness level by playing with it.
4. **Check Status**: View the current hunger and happiness levels of the pet.
5. **End Game**: End the game and view the final status of the pet.

## Project Structure

### Java Console Application
- **POP & OOP**: The game logic was implemented using both procedural and object-oriented approaches, ensuring that the design is flexible and reusable.
- **Manual Testing**: Each feature was manually tested to ensure that all edge cases and scenarios are handled correctly.

## Features and Functionality
### Adopt a Pet
-**Purpose**: To start the game by adopting a pet.

-**Process**:
1.  Name: Enter the name of the pet. This name will be used to identify the pet throughout the game.
2.	Initial Levels: Set the initial hunger and happiness levels to 50 each.
3.	Confirmation: The system confirms that the pet has been adopted and is ready to be cared for.

### Feed the Pet
-**Purpose**: To increase the pet's hunger level by feeding it.

-**Process**:
1.	Increase Hunger: If the pet's hunger level is below 90, feeding it will increase the hunger level by 10.
2.	Full Condition: If the hunger level is already at 90, the pet is considered full, and no further increase is allowed.

### Play with the Pet
-**Purpose**: To increase the pet's happiness level by playing with it.

-**Process**:
1.	Increase Happiness: If the pet's happiness level is below 90, playing with it will increase the happiness level by 10.
2.	Satisfaction Condition: If the happiness level is already at 90, the pet is considered too happy, and no further increase is allowed.

### Check Status
-**Purpose**: To view the current status of the pet. 

-**Information Provided**:
1.	Hunger Level: Displays the current hunger level of the pet.
2.	Happiness Level: Displays the current happiness level of the pet.

### End Game
-**Purpose**: To end the game and view the final status of the pet.

-**Process**:
1.	Final Status: The system shows the final hunger and happiness levels before ending the game.
2.	Game Over: The game ends, and the user is informed that the game is over.


## How to Play

1. **Adopt a Pet**: Choose a pet from the available options and give it a name.
2. **Interact with Your Pet**: You can feed your pet to reduce hunger or play with it to increase happiness.
3. **Monitor the Pet’s Status**: Keep an eye on your pet's hunger and happiness levels.
4. **End Game**: The game will end if the pet's hunger or happiness reaches critical levels. You can also manually end the game and view the final status of your pet.

## Testing

### Manual Testing
- Each feature and interaction was manually tested to ensure proper functionality.
[Manual test](https://docs.google.com/spreadsheets/d/1kSyavnK3LL2xU1uAcow6kbD7keFH2O3Zy111wen7giA/edit?gid=1726167983#gid=1726167983)


### Automated Testing
- **Selenium**: Automation tests were written using Selenium to validate the web-based simulation and ensure that all user interactions are functioning as expected.
- **Flowchart**: A flowchart was created to illustrate the logic and possible states of the pet, ensuring a clear understanding of game progression.

![My Pet](Project1/Automation test/Untitled.png)

- **HTML & JavaScript**: We developed a web-based simulation of the Pet Adoption Game, allowing users to interact with their virtual pets through a browser interface.


## Contributors

- Hassan Ashraf
- Mohamed Abdelwahed
- Abraam Sobhy
