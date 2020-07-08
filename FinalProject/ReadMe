# **Javafx Battleship**

## Synopsis
This is a game of Battleship, it is a two player game where the first player picks the number of ships
and places them in a grid. after which the second player tries to sink the ships.

## Motivation
This is a program for the Object Oriented Programming CSCI-1110-OOP class at Southwest Tech. I created this program for my final project in that clas as it encompasses the requirements of the assignment.

## How to Play
This game is played using a javafx GUI.

The game is played by the first player (the player owning the boats) picks the number of boats
and places them in a 5x5 grid, choosing the ship placement by clicking the radio buttons at the top section of the pane with the mouse.[Boat PLacement.png](https://github.com/JasonW77/CSCI_1110_OOP_Coursework/blob/master/Final%20Project/Boat%20PLacement.png) 
After the boat player has chosen the boat positions, the player will then click the confirm button to pass the turn to the second player or the "Bombs" player.
The bombs player will choose the placement of the bombs to try and sink the ships. the placement of bombs is done by clicking the button grid at the bottom section of the pane with the mouse.
[BombPlayerturn.png](https://github.com/JasonW77/CSCI_1110_OOP_Coursework/blob/master/Final%20Project/Bomb%20Player%20turn.png)
the "Bomb" player will have 3 more bombs than the number of ships placed to try and sink the boat players ships.

after all boats have been sunk, or all bombs have been dropped and there are boats left the game is over.[Game Over Example](https://github.com/JasonW77/CSCI_1110_OOP_Coursework/blob/master/Final%20Project/Game%20end.png)
there will be a print out of the score in the console and the game will restart.
[Score Sheet](https://github.com/JasonW77/CSCI_1110_OOP_Coursework/blob/master/Final%20Project/Score%20sheet.png), this time the second player will be placing the boats and the first player will be dropping bombs.




## Code Example
here is a code example of player one placing thier ships.

```
//Boat counter radio button onActions these keep track of the number of boats placed.
			rb1_1.setOnAction(e -> {
				if (rb1_1.isSelected()) {
					boats++;
					btLeft.setDisable(false);
				}
				else {
					boats--;
					if(boats <= 0) {
						btLeft.setDisable(true);
					}
				}
			});
```
## Code Example
here is a code example of player two dropping thier bombs.

```
//Bomb Drop Buttons setOnAction assignments, changes color for hit/miss as well as counts the hit/miss counters and depletes bomb count
			bo1_1.setOnAction(e -> {
				if (rb1_1.isSelected()) {
					rb1_1.setStyle("-fx-color: RED");
					rb1_1.setVisible(true);
					bo1_1.setDisable(true);
					hits++;
					boatleft--;
				}
				else {
					rb1_1.setStyle("-fx-color: LIGHTBLUE");
					rb1_1.setVisible(true);
					bo1_1.setDisable(true);
					miss++;
				}
				bombs--;
				gameOver();
			});
```

## Tests
there are no value returning methods.
