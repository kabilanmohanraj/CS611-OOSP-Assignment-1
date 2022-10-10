# CS611-OOSP-Assignment-1
## Tic Tac Toe & Order And Chaos

The repository holds the Java source code for the Tic Tac Toe + Order and Chaos board games incorporating object oriented principles for scalaility and extendability.

## Files
---------------------------------------------------------------------------
### Default package
1. `Driver.java` -> The class is the entry point to the game and contains the main() method.
2. `GameSelector.java` -> The class is responsible for displaying the menu of available games and present rules for the selected game.
3. `BoardCell.java` -> The class is responsible for encapsulating a single cell/component of the given board. In other words, it is the building block of a board.
4. `Board.java` -> The class is a defined collection of cells/companents that make up the board. Acts as the parent class for all game boards.
5. `BoardGame.java` -> It is an abstract class which provides the necessary functions that is common to all board games improving scalability and extendability.
6. `Player.java` ->  The class contains all the information with respect to the player. The class can be extended for the player to move pieces instead of just placing pieces, through an interface. 
7. `Keys.java` -> Unimplemented class in this assignment. The plan is to use the class to extend the framework to implement diverse board games which involve unique piece behaviour.

### OacGame package
1. `OacBoard.java` -> The class is a subclass of the `Board` class. The class represents the board specific to the game "Order and Chaos".
2. `OacGameDriver.java` -> The class is the game driver for "Order and Chaos". Includes player selection, checking winning conditions etc.

### TttGame package
1. `TttBoard.java` -> The class is a subclass of the `Board` class. The class represents the board specific to the game "Tic Tac Toe". Provides the flexibility to change game board sizes as preferred by the players.
2. `TttGameDriver.java` -> The class is the game driver for "Tic Tac Toe". Includes player selection, checking winning conditions etc.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory `tic-tac-toe` after unzipping the files
2. Run the following instructions:
>`javac -d bin src/**/*.java` \
>`java -cp bin Default.Driver`

## Input/Output Example
---------------------------------------------------------------------------
```
***=== Welcome to the board games arena ===***

[1]  Tic Tac Toe
[2]  Order and Chaos

[Input] Choose game to play: 1

Starting Tic Tac Toe! Please note the following.


    1. Player 1 will always begin first. Player 1's assigned marker is 'X' and Player 2's is 'O'
    2. Chosen size of the board can only be from 3x3 to 10x10.


[Input] === Please enter name for PLAYER 1 ===
Alice

[Input] === Please enter name for PLAYER 2 ===
Bob

[Input] === Please enter a board size between 3 - 10 ===
=== For example, number 3 will generate a 3x3 board, number 4 will generate a 4x4 board and so on. ===

3

=== Preferred board size has been received. ===
=== Creating the board... ===

[Output]


+-------+-------+-------+
|   1   |   2   |   3   |
+-------+-------+-------+
|   4   |   5   |   6   |
+-------+-------+-------+
|   7   |   8   |   9   |
+-------+-------+-------+

X >>> Goes first
[Input] >>> Please enter the cell number you would like to place the marker on: 
1
[Output]


+-------+-------+-------+
|   X   |   2   |   3   |
+-------+-------+-------+
|   4   |   5   |   6   |
+-------+-------+-------+
|   7   |   8   |   9   |
+-------+-------+-------+

[Input] >>> Please enter the cell number you would like to place the marker on: 
4
[Output]


+-------+-------+-------+
|   X   |   2   |   3   |
+-------+-------+-------+
|   O   |   5   |   6   |
+-------+-------+-------+
|   7   |   8   |   9   |
+-------+-------+-------+

[Input] >>> Please enter the cell number you would like to place the marker on: 
9
[Output]


+-------+-------+-------+
|   X   |   2   |   3   |
+-------+-------+-------+
|   O   |   5   |   6   |
+-------+-------+-------+
|   7   |   8   |   X   |
+-------+-------+-------+

[Input] >>> Please enter the cell number you would like to place the marker on: 
5
[Output]


+-------+-------+-------+
|   X   |   2   |   3   |
+-------+-------+-------+
|   O   |   O   |   6   |
+-------+-------+-------+
|   7   |   8   |   X   |
+-------+-------+-------+

[Input] >>> Please enter the cell number you would like to place the marker on: 
3
[Output]


+-------+-------+-------+
|   X   |   2   |   X   |
+-------+-------+-------+
|   O   |   O   |   6   |
+-------+-------+-------+
|   7   |   8   |   X   |
+-------+-------+-------+

[Input] >>> Please enter the cell number you would like to place the marker on: 
6
[Output]


+-------+-------+-------+
|   X   |   2   |   X   |
+-------+-------+-------+
|   O   |   O   |   O   |
+-------+-------+-------+
|   7   |   8   |   X   |
+-------+-------+-------+

>>> Player 2 wins the game!!! >>>
>>> Updating score board... >>>

=== Game has ended ===


=== Would you like to play another round? ===

[Input] === Hit "y/Y" to play again! Or hit any other key to exit.
n
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Score summary for games played:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
=== # PLAYER 1 WINS >>>  0
=== # PLAYER 1 LOSES >>> 1
=== # PLAYER 2 WINS >>>  1
=== # PLAYER 2 LOSES >>> 0
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


=== Would you like to play Order and Chaos? ===
[Input] === Hit "y/Y" to play Order and Chaos! Or hit any other key to exit. ===
y

Starting Order and Chaos! Please note the following.


    1. Player 1 will play 'Order' and Player 2 will play 'Chaos'.
    2. Order plays first.
    3. The size of the board is fixed to be 6x6.
    4. Winning condition >>> 'Order' wins when there are 5 continuous markers (6 continuous markers is not a win for Order and the game will continue till 5 consecutive markers are placed). And 'Chaos' wins when the board is filled with no 5 continuous markers of 'X's or 'O's.


[Input] === Please enter name for PLAYER 1 ===
Alice

[Input] === Please enter name for PLAYER 2 ===
Bob

[Output]

+-------+-------+-------+-------+-------+-------+
|   1   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |  22   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |  36   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
1

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |  22   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |  36   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |  22   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |  36   |
+-------+-------+-------+-------+-------+-------+

To play >>> Bob
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
36

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |  22   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |  22   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
22

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   8   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Bob
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
8

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |  15   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
15

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |  29   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Bob
[Input] === Please enter which marker to place > 'X' or 'O' ===
X
[Input] >>> Please enter the cell number you would like to place the marker on: 
29

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   6   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
O
[Input] >>> Please enter the cell number you would like to place the marker on: 
6

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |  12   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Bob
[Input] === Please enter which marker to place > 'X' or 'O' ===
O
[Input] >>> Please enter the cell number you would like to place the marker on: 
12

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |  18   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
O
[Input] >>> Please enter the cell number you would like to place the marker on: 
18

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |   O   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |   O   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |  24   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Bob
[Input] === Please enter which marker to place > 'X' or 'O' ===
O
[Input] >>> Please enter the cell number you would like to place the marker on: 
24

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |   O   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |   O   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+


[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |   O   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |   O   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |  30   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

To play >>> Alice
[Input] === Please enter which marker to place > 'X' or 'O' ===
O
[Input] >>> Please enter the cell number you would like to place the marker on: 
30

[Output]

+-------+-------+-------+-------+-------+-------+
|   X   |   2   |   3   |   4   |   5   |   O   |
+-------+-------+-------+-------+-------+-------+
|   7   |   X   |   9   |  10   |  11   |   O   |
+-------+-------+-------+-------+-------+-------+
|  13   |  14   |   X   |  16   |  17   |   O   |
+-------+-------+-------+-------+-------+-------+
|  19   |  20   |  21   |   X   |  23   |   O   |
+-------+-------+-------+-------+-------+-------+
|  25   |  26   |  27   |  28   |   X   |   O   |
+-------+-------+-------+-------+-------+-------+
|  31   |  32   |  33   |  34   |  35   |   X   |
+-------+-------+-------+-------+-------+-------+

>>> Order wins the game!!! >>>
>>> Updating score board... >>>

=== Game has ended ===


=== Would you like to play another round? ===

[Input] === Hit "y/Y" to play again! Or hit any other key to exit.
n
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Score summary for games played:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
=== # ORDER WINS >>>  1
=== # ORDER LOSES >>> 0
=== # CHAOS WINS >>>  0
=== # CHAOS LOSES >>> 1
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


=== Would you like to play Tic Tac Toe? ===
[Input] === Hit "y/Y" to play Tic Tac Toe! Or hit any other key to exit. ===
n
=== Exiting the game now! See you again!!! ===
```