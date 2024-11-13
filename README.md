# Magical Arena Game

## Overview

**Magical Arena** is a simple turn-based combat simulation game where two players, Player A and Player B, compete in a battle. Each player has stats for health, strength, and attack power, and the game alternates between players attacking each other. The winner is determined when one player's health reaches zero.

This program is written in Java and demonstrates basic object-oriented programming concepts, including encapsulation, methods, and game logic.

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
  
## How It Works
1. *User Input:* The game begins by asking the user to enter the stats for each player:

- Health: Determines the player’s endurance.
- Strength: Impacts the player’s defensive power.
- Attack: Influences the player’s offensive power.
  
2. *Game Stimulation* 
- During each turn, players take turns attacking each other.
- A six-sided die is rolled to determine both the attacking power of the attacker and the defensive power of the opponent.
- The net damage is calculated as follows:
  net damage=max(0,(attack×attack roll)−(strength×defense roll))
- The opponent’s health is reduced by the net damage dealt.

3. *Game Flow:*
- The player with lower health starts the turn. If both players have equal health, Player A attacks first.
- After each attack, the program checks if the attacked player’s health has reached zero.
- If a player’s health is zero or below, the game announces the winner and ends.

## Unit Tests

Unit tests are written using **JUnit** and cover the following:
- **Dice Rolls**: Ensure that the dice rolls return a valid number between 1 and 6.
- **Attack and Defense Calculations**: Validate the damage calculation and health reduction logic.
- **Game Flow**: Ensure that the game ends when a player’s health reaches zero.

### Example Test Case:

```output
Enter stats for Player A:
Health: 50
Strength: 5
Attack: 10
Enter stats for Player B:
Health: 100
Strength: 10
Attack: 5

The match begins!

Player A attacks!
Player A rolls 4 (Attack: Player A), Player B rolls 5 (Defense: Player B)
Net Damage to Player B: 0 | Player B's Remaining Health: 100

Player B attacks!
Player B rolls 2 (Attack: Player B), Player A rolls 3 (Defense: Player A)
Net Damage to Player A: 0 | Player A's Remaining Health: 50

-----
Player A attacks!
Player A rolls 5 (Attack: Player A), Player B rolls 1 (Defense: Player B)
Net Damage to Player B: 40 | Player B's Remaining Health: 60

Player B attacks!
Player B rolls 4 (Attack: Player B), Player A rolls 4 (Defense: Player A)
Net Damage to Player A: 0 | Player A's Remaining Health: 50

-----
Player A attacks!
Player A rolls 5 (Attack: Player A), Player B rolls 2 (Defense: Player B)
Net Damage to Player B: 30 | Player B's Remaining Health: 30

Player B attacks!
Player B rolls 1 (Attack: Player B), Player A rolls 3 (Defense: Player A)
Net Damage to Player A: 0 | Player A's Remaining Health: 50

-----
Player B attacks!
Player B rolls 6 (Attack: Player B), Player A rolls 6 (Defense: Player A)
Net Damage to Player A: 0 | Player A's Remaining Health: 50

Player A attacks!
Player A rolls 6 (Attack: Player A), Player B rolls 3 (Defense: Player B)
Net Damage to Player B: 30 | Player B's Remaining Health: 0

Player B has been defeated! Player A wins!
Game over.

```

## Code Quality

- **Readability**: The code follows consistent naming conventions, and each class and method has a single responsibility.
- **Maintainability**: The code is modular, making it easy to extend and modify.
- **Design**: The `Player` and `MagicalArena` classes encapsulate related behaviors, with clear separation of concerns.

## Future Improvements

- **Multiple Rounds**: Introduce multiple rounds where players can heal or use special abilities.
- **Player Customization**: Allow players to customize characters with magical powers or items.
- **Graphical Interface**: Create a GUI for a more interactive experience.

---
