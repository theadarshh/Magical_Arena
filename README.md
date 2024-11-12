# Magical Arena: A Turn-based Combat Game

## Overview

**Magical Arena** is a player-versus-player combat game where two players battle in a turn-based system. Each player has three attributes: health, strength, and attack. Players attack and defend in turns, and the game continues until one player's health reaches zero.

The core mechanics are as follows:
- **Attack**: The attacking player rolls a die and multiplies the roll by their attack attribute to calculate damage.
- **Defense**: The defending player rolls a die and multiplies the roll by their strength attribute to calculate defense.
- **Health Reduction**: The excess damage after defense is subtracted from the defender’s health.

The player with lower health attacks first.

## Problem Statement

- Each player has `health`, `strength`, and `attack` attributes, all positive integers.
- Players attack in turns: the attacking player rolls an attacking die, and the defender rolls a defending die.
- The **attack damage** is calculated as:  
  `attack_roll * attack_value`  
  The **defending damage** is calculated as:  
  `defense_roll * strength_value`
- The damage dealt to the defender is the excess of the attacking damage over the defending damage.
- The game ends when any player’s health reaches zero.

## Features

- **Turn-based Combat**: Players attack and defend in turns.
- **Random Dice Rolls**: Both attack and defense are determined by random dice rolls (between 1 and 6).
- **Health Tracking**: Each player's health decreases based on the outcome of each turn.
- **Player Attributes**: Each player has `health`, `strength`, and `attack` attributes that affect their performance in combat.
- **Attack Order**: The player with the lower health attacks first.

## Prerequisites
- Java 8 or higher
- Eclipse IDE (for running the project in Eclipse)

## Code Design and Structure

The code follows object-oriented principles with a focus on modeling the main entities (players and the arena) and their behaviors.

### **Player Class**

The `Player` class represents a single player with attributes: `health`, `strength`, and `attack`. Methods include:
- `rollDie()`: Simulates the dice roll for both attacking and defending.
- `attack(Player opponent)`: Executes the attack against another player, calculating the damage and updating health.

### **MagicalArena Class**

The `MagicalArena` class contains the game loop. It initializes the players and handles:
- Player input for attributes (health, strength, attack).
- Turn-based combat where players alternate attacking and defending.
- Ends the game when a player's health reaches zero.

## Unit Tests

Unit tests are written using **JUnit** and cover the following:
- **Dice Rolls**: Ensure that the dice rolls return a valid number between 1 and 6.
- **Attack and Defense Calculations**: Validate the damage calculation and health reduction logic.
- **Game Flow**: Ensure that the game ends when a player’s health reaches zero.

### Example Test Case:

```java
@Test
public void testAttackCalculation() {
    Player playerA = new Player("Player A", 50, 10, 5);
    Player playerB = new Player("Player B", 100, 5, 10);
    
    playerA.attack(playerB);
    
    assertEquals(70, playerB.getHealth());
}
```

## Code Quality

- **Readability**: The code follows consistent naming conventions, and each class and method has a single responsibility.
- **Maintainability**: The code is modular, making it easy to extend and modify.
- **Design**: The `Player` and `MagicalArena` classes encapsulate related behaviors, with clear separation of concerns.

## Future Improvements

- **Multiple Rounds**: Introduce multiple rounds where players can heal or use special abilities.
- **Player Customization**: Allow players to customize characters with magical powers or items.
- **Graphical Interface**: Create a GUI for a more interactive experience.

## GitHub Repository

The full code and additional details for the **Magical Arena** game can be found in the GitHub repository:  
[Magical Arena - GitHub Repository](https://github.com/theadarshh/Magical_Arena.git)

--- 
