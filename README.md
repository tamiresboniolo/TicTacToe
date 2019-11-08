# TicTacToe

4x4 Tic-Tac-Toe Game
This program allows two players to play a game of tic-tac-toe on 4x4 board.
Game user interface description:
1. Two players are playing a game, taking turns to make a move. Player 1 places Xs,
and player 2 places Os on the 4x4 board. Player 1 wins when there are three Xs in
a row on the game board (player 2 wins when there are three Os). Three Xs (or
Os) can appear in a row, in a column, or diagonally across the board. A tie occurs
when all of the locations on the board are full, but there is no winner.

2. On each turn the board is being displayed. 
When the user wants to make a move, he/she chooses a number (kind of a Hex
system), that represents the placement of X or O on the board.

3. This exchange goes on until one of the players wins or there is a tie.

4. Public method simulateInput(char player, char letter) –
The method is for debugging purposes. It simulates a move of a user. The
first parameter specifies the player (X or O), the second parameter specifies the
move (as a character).

5. Public method analyzeBoard() – analyzes the current board and determines
if there is a winning position present or if it is a tie. If the state of the game
changes, the member variable that is tracking the game state must be changing
value, and the info about the winner must be recorded in the field that stores that
data.

6. Public method done() – accessor for status field. Method returns true if the
game came to the end.

7. Public method whoWon() – returns a character (X, O or T – for tie), a value of
the winner field
