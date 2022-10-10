package OacGame;

import java.util.Scanner;

import Default.BoardCell;
import Default.BoardGame;
import Default.Player;
import TttGame.TttGameDriver;

public class OacGameDriver extends BoardGame {

    private Player order;
    private Player chaos;
    private OacBoard oacBoard;
    private int markerIndex; // To track the number of row, column and diagonal markers (i.e) 'X' and 'O' repectively.
    private boolean startingPlay;

    Scanner input = new Scanner(System.in);

    public OacGameDriver() {
        super();
        requestPlayerNames();
        this.order = getPlayer1();
        this.chaos = getPlayer2();

        setBoard(new OacBoard());
        oacBoard = (OacBoard) getBoard();

        rows = new int[6][2];
        columns = new int[6][2];
        diagonals = new int[6][2];
    }

    @Override
    public void startGame() {
        playGame();
    }

    @Override
    public void playGame() {
        Player currentPlayer;
        int winnerPlayer, positionPlayed;
        String playerMarker;
        
        oacBoard.printBoard();

        // Condition to put Order to play first always when a game starts
        if(playerQueue.peek() == chaos) {
            System.out.println(playerQueue.peek().getPlayerName());
            System.out.println(getNextPlayer(order, chaos).getPlayerName());
        }

        while(true) {
            currentPlayer = getNextPlayer(order, chaos);

            System.out.println("To play >>> "+currentPlayer.getPlayerName());
            System.out.println("[Input] === Please enter which marker to place > 'X' or 'O' ===");
            playerMarker = input.next();
            if (playerMarker.charAt(0) == 'X') {
                markerIndex = 0;
            } else {
                markerIndex = 1;
            }
            positionPlayed = currentPlayer.placeTheKey(oacBoard, Character.toUpperCase(playerMarker.charAt(0)));
            numberOfMarkersPlaced += 1;
            winnerPlayer = checkWinner(positionPlayed, markerIndex);

            oacBoard.printBoard();

            if (winnerPlayer == 1) {
                // Order is the winner
                System.out.println(">>> Order wins the game!!! >>>");
                System.out.println(">>> Updating score board... >>>");
                order.updateGameHistory(1, 0);
                chaos.updateGameHistory(0, 1);
                break;
            } else if (numberOfMarkersPlaced == 36 && winnerPlayer == -1) {
                // Chaos is the winner
                System.out.println(">>> Chaos wins the game!!! >>>");
                System.out.println(">>> Updating score board... >>>");
                chaos.updateGameHistory(1, 0);
                order.updateGameHistory(0, 1);
                break;
            } else {
                // Game continues
                oacBoard.printBoard();
                continue; // IMPORTANT! If no winner generated, skip the 2 lines below
            }
        }
        playAgainOrExit();
    }

    @Override
    public void checkWinner() {} 
    
    public int checkWinner(int positionPlayed, int markerIndex) {
        
        BoardCell[][] currentBoard = this.oacBoard.getBoard();
        int row = oacBoard.positionToIndex(positionPlayed)[0] - 1;
        int col = oacBoard.positionToIndex(positionPlayed)[1] - 1;

        if (++rows[row][markerIndex] == 5) {
            // If a row has 5 like pieces
            if (currentBoard[row][0].getCellPiece() != currentBoard[row][5].getCellPiece()) {
                // If the 5 like pieces are consecutive (i.e. 5-in-a-row)
                return 1; // 1 means Order wins
            }
        }
        if (++columns[col][markerIndex] == 5) {
            if (currentBoard[0][col].getCellPiece() != currentBoard[5][col].getCellPiece()) {
                return 1;
            }
        }
        if (row == col && ++diagonals[0][markerIndex] == 5) {
            if (currentBoard[0][0].getCellPiece() != currentBoard[5][5].getCellPiece()) {
                return 1;
            }
        }
        if ((row + col == 5) && ++diagonals[1][markerIndex] == 5) {
            if (currentBoard[0][5].getCellPiece() != currentBoard[5][0].getCellPiece()) {
                return 1;
            }
        }
        if ((row == (col - 1)) && ++diagonals[2][markerIndex] == 5) {
            return 1;
        }
        if ((row + col == 4) && ++diagonals[3][markerIndex] == 5) {
            return 1;
        }
        if ((col == (row - 1)) && ++diagonals[4][markerIndex] == 5) {
            return 1;
        }
        if ((row + col == 6) && ++diagonals[5][markerIndex] == 5) {
            return 1;
        }

        return -1; // Order has not won yet

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
            numberOfMarkersPlaced = 0;

            oacBoard = new OacBoard();
            rows = new int[6][2];
            columns = new int[6][2];
            diagonals = new int[6][2];

            startGame();
        }
        else {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Score summary for games played:");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.print("=== # ORDER WINS >>>  ");
            System.out.println(order.getGameHistory()[0]);
            System.out.print("=== # ORDER LOSES >>> ");
            System.out.println(order.getGameHistory()[1]);

            System.out.print("=== # CHAOS WINS >>>  ");
            System.out.println(chaos.getGameHistory()[0]);
            System.out.print("=== # CHAOS LOSES >>> ");
            System.out.println(chaos.getGameHistory()[1]);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            System.out.println("\n\n=== Would you like to play Tic Tac Toe? ===");
            System.out.println("[Input] === Hit \"y/Y\" to play Tic Tac Toe! Or hit any other key to exit. ===");

            switchGameChoice = input.nextLine();
            
            if (switchGameChoice.equalsIgnoreCase("Y")) {

                new TttGameDriver().startGame();

            } else {
                System.out.println("=== Exiting the game now! See you again!!! ===");
                input.close();
                System.exit(0);
            }
        }
    }
    
}
