package TttGame;
import java.util.Scanner;

import Default.BoardGame;
import Default.Player;
import OacGame.OacGameDriver;

public class TttGameDriver extends BoardGame {

    private Player player1;
    private Player player2;
    private TttBoard tttBoard;
    
    public TttGameDriver() {
        super();
        requestPlayerNames();
        this.player1 = getPlayer1();
        this.player2 = getPlayer2();

        requestPlayerPreferredBoardSize();
        setBoard(new TttBoard(boardSize));
        tttBoard = (TttBoard) getBoard();

        rows = new int[3][boardSize];
        columns = new int[3][boardSize];
        diagonals = new int[3][2];
    }

    public void startGame() {
        playGame();
    }

    public void playGame() {
        Player currentPlayer;
        int positionPlayed;
        int winnerPlayer;
        char playerMarker;
        boolean whoGoesFirst = true;

        tttBoard.printBoard();

        while(true) {
            currentPlayer = getNextPlayer(player1, player2);
            if(whoGoesFirst) {
                System.out.print(currentPlayer.getPlayerMarker());
                System.out.print(" >>> Goes first\n");
                whoGoesFirst = false;
            }
            playerMarker = currentPlayer.getPlayerMarker();
            positionPlayed = currentPlayer.placeTheKey(tttBoard, playerMarker);
            numberOfMarkersPlaced += 1;
            winnerPlayer = checkWinner(positionPlayed, currentPlayer, numberOfMarkersPlaced%2);
            
            tttBoard.printBoard();

            if (winnerPlayer == 0) {
                // Player 2 wins (because modulus fpr player 2 will be 0)
                System.out.println(">>> Player 2 wins the game!!! >>>");
                System.out.println(">>> Updating score board... >>>");
                player2.updateGameHistory(1, 0);
                player1.updateGameHistory(0, 1);
                break;
            } else if (winnerPlayer == 1) {
                // Player 1 wins
                System.out.println(">>> Player 1 wins the game!!! >>>");
                System.out.println(">>> Updating score board... >>>");
                player1.updateGameHistory(1, 0);
                player2.updateGameHistory(0, 1);
                break;
            } else if ((numberOfMarkersPlaced == boardSize * boardSize) && (winnerPlayer == -1)) {
                // Stalemate
                System.out.println("=== The game is a draw ===");
                break;
            }
            // else {
            //     continue; // If no winner, skip the code below.
            // }
        }
        playAgainOrExit();
    }

    @Override
    public void checkWinner() {}

    // Overload the checkWinner() method
    public int checkWinner(int positionPlayed, Player player, int playerNumber) {

        int row = tttBoard.positionToIndex(positionPlayed)[0] - 1;
        int column = tttBoard.positionToIndex(positionPlayed)[1] - 1;

        if (++rows[playerNumber][row] == boardSize) {
            return playerNumber;
        }
        if (++columns[playerNumber][column] == boardSize) {
            return playerNumber;
        }
        if (row == column && ++diagonals[playerNumber][0] == boardSize) {
            return playerNumber;
        }
        if ((row + column == boardSize - 1) && ++diagonals[playerNumber][1] == boardSize) {
            return playerNumber;
        }
        return -1; // No winner
    }

    @Override
    public void playAgainOrExit() {
        System.out.println("\n=== Game has ended ===\n");
        System.out.println("\n=== Would you like to play another round? ===\n");
        System.out.println("[Input] === Hit \"y/Y\" to play again! Or hit any other key to exit.");

        String userChoice;
        String switchGameChoice;
        Scanner input = new Scanner(System.in);

        userChoice = input.nextLine();
        if(userChoice.equalsIgnoreCase("Y")) {
            // reset the game variables

            requestPlayerPreferredBoardSize();
            numberOfMarkersPlaced = 0;

            tttBoard = new TttBoard(boardSize);
            rows = new int[3][boardSize];
            columns = new int[3][boardSize];
            diagonals = new int[3][2];

            startGame();
        }
        else {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Score summary for games played:");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.print("=== # PLAYER 1 WINS >>>  ");
            System.out.println(player1.getGameHistory()[0]);
            System.out.print("=== # PLAYER 1 LOSES >>> ");
            System.out.println(player1.getGameHistory()[1]);

            System.out.print("=== # PLAYER 2 WINS >>>  ");
            System.out.println(player2.getGameHistory()[0]);
            System.out.print("=== # PLAYER 2 LOSES >>> ");
            System.out.println(player2.getGameHistory()[1]);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            System.out.println("\n\n=== Would you like to play Order and Chaos? ===");
            System.out.println("[Input] === Hit \"y/Y\" to play Order and Chaos! Or hit any other key to exit. ===");

            switchGameChoice = input.nextLine();
            
            if (switchGameChoice.equalsIgnoreCase("Y")) {

                new OacGameDriver().startGame();

            } else {
                System.out.println("=== Exiting the game now! See you again!!! ===");
                input.close();
                System.exit(0);
            }
        }
    }
}
