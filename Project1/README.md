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

### Web Simulation
- **HTML & JavaScript**: We developed a web-based simulation of the Pet Adoption Game, allowing users to interact with their virtual pets through a browser interface.
- **Flowchart**: A flowchart was created to illustrate the logic and possible states of the pet, ensuring a clear understanding of game progression.

### Automated Testing
- **Selenium**: Automation tests were written using Selenium to validate the web-based simulation and ensure that all user interactions are functioning as expected.

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/username/pet-adoption-game.git
    cd pet-adoption-game
    ```

2. **Run the Console Application**:
    - Compile and run the Java code:
    ```bash
    javac PetAdoptionGame.java
    java PetAdoptionGame
    ```

3. **Web Simulation**:
    - Open the `index.html` file in your browser to start the web-based simulation.

## How to Play

1. **Adopt a Pet**: Choose a pet from the available options and give it a name.
2. **Interact with Your Pet**: You can feed your pet to reduce hunger or play with it to increase happiness.
3. **Monitor the Pet’s Status**: Keep an eye on your pet's hunger and happiness levels.
4. **End Game**: The game will end if the pet's hunger or happiness reaches critical levels. You can also manually end the game and view the final status of your pet.

## Testing

### Manual Testing
- Each feature and interaction was manually tested to ensure proper functionality.

### Automated Testing
- Selenium was used for automated testing of the web-based simulation, ensuring that user interactions such as feeding and playing with the pet work correctly across different browsers.

## Flowchart

A flowchart was created to outline the game's possible states and transitions. This provides a clear visual of the game logic and helps in both development and testing.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributors

- [Your Name](https://github.com/yourusername)
