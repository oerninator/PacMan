
# PacMan

This is a PacMan game developed using the Model-View-Controller (MVC) pattern in Java. The game is playable on the high-rise building of the University of Kiel.

## Features

- Playable PacMan game with graphical user interface.
- Implements the MVC design pattern to separate concerns.
- Compatible with the Lighthouse display at the University of Kiel.
- Includes ghosts with AI to chase the player.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/pacman.git
    ```
2. Navigate to the project directory:
    ```bash
    cd pacman/PacManGame
    ```
3. Compile the Java files:
    ```bash
    javac src/main/java/pacMan/*.java
    ```

## Usage

1. Run the PacMan game:
    ```bash
    java src/main/java/pacMan/Main
    ```

## Project Structure

```
PacMan/
    ├── Connection.java
    ├── Controller.java
    ├── DesktopView.java
    ├── Ghost.java
    ├── LighthouseView.java
    ├── Model.java
    ├── Player.java
    ├── Point.java
    ├── RealTime.java
    └── View.java
```

- **`Connection.java`**: Manages the connection to the lighthouse display.
- **`Controller.java`**: Handles game logic and user interactions.
- **`DesktopView.java`**: Provides a desktop-based graphical user interface.
- **`Ghost.java`**: Represents the ghost enemies in the game with AI to chase the player.
- **`LighthouseView.java`**: Provides a view for displaying the game on the lighthouse at the University of Kiel.
- **`Model.java`**: Maintains the game state, including the player and ghost positions.
- **`Player.java`**: Represents the player character, PacMan.
- **`Point.java`**: Helper class to represent x and y coordinates.
- **`RealTime.java`**: Handles real-time updates of the game state.
- **`View.java`**: Interface for views to implement to be notified of updates in the game state.

## Classes and Methods

### Connection.java

- **Connection()**: Manages the connection setup and communication with the lighthouse display.

### Controller.java

- **start()**: Initializes and starts the game loop.
- **updateViews()**: Updates the views based on the current game state.

### DesktopView.java

- **update(Model world)**: Updates the desktop view when the game state changes.

### Ghost.java

- **move()**: Logic for moving the ghost characters.
- **chasePlayer()**: AI for ghosts to chase the player.

### LighthouseView.java

- **update(Model world)**: Updates the lighthouse display when the game state changes.

### Model.java

- **update()**: Updates the game state, including player and ghost movements.
- **getPlayer()**: Returns the player object.
- **getGhosts()**: Returns a list of ghost objects.

### Player.java

- **move()**: Logic for moving the player character.
- **getPosition()**: Returns the current position of the player.

### Point.java

- **Point(double x, double y)**: Constructor to initialize x and y coordinates.
- **getX()**: Returns the x coordinate.
- **getY()**: Returns the y coordinate.

### RealTime.java

- **run()**: Continuously updates the game state in real-time.

### View.java

- **update(Model world)**: Method to be implemented by views to update their display.

## Contribution

Feel free to contribute to this project by creating pull requests or reporting issues. Your feedback and contributions are highly appreciated.

## License

This project is licensed under the GPL 3.0 License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, please contact me at arneseufert@web.de.

---

Thank you for playing PacMan!
