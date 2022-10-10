package Default;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public abstract class BoardGame {

    Scanner input = new Scanner(System.in);

    protected Player player1;
    protected Player player2;
    protected Queue<Player> playerQueue = new LinkedList<>();

    protected int boardSize;
    protected Board board;

    // Game win check condition
    protected int numberOfMarkersPlaced;
    protected int[][] rows;
    protected int[][] columns;
    protected int[][] diagonals;

    public BoardGame() {
        boardSize = 0;
        numberOfMarkersPlaced = 0;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract void startGame();  // abstract to method start playing the game

    public abstract void playGame();

    protected void requestPlayerNames() {
        System.out.println("\n[Input] === Please enter name for PLAYER 1 ===");
        String player1Name = input.next();
        player1 = new Player(player1Name, 'X');
        player1.setPlayerName(player1Name);

        System.out.println("\n[Input] === Please enter name for PLAYER 2 ===");
        String player2Name = input.next();
        player2 = new Player(player2Name, 'O');
        player2.setPlayerName(player2Name);

        playerQueue.add(player1);
        playerQueue.add(player2);
    }

    protected void requestPlayerPreferredBoardSize() {
        int boardSizeCeiling = 10;
        int boardSizeFloor = 3;

        System.out.println("\n[Input] === Please enter a board size between 3 - 10 ===");
        System.out.println("=== For example, number 3 will generate a 3x3 board, number 4 will generate a 4x4 board and so on. ===\n");

        if(input.hasNextInt()) {
            boardSize = input.nextInt();
            if(boardSize < boardSizeFloor || boardSizeCeiling > boardSizeCeiling) {
                System.out.println("\n=== You have entered a size outside the range. Please enter a number from 3 - 10 ===\n");
                requestPlayerPreferredBoardSize();
            }
            else {
                System.out.println("\n=== Preferred board size has been received. ===\n=== Creating the board... ===\n");
            }
        }
        else {
            System.out.println("\n=== You have entered an invalid input. Please enter an INTEGER! (e.g) 3/4/5... ===\n");
            requestPlayerPreferredBoardSize();
        }
    }

    protected Player getNextPlayer(Player player1, Player player2) {
        Player currentPlayer = playerQueue.remove();
        playerQueue.add(currentPlayer);
        return currentPlayer;
    }

    public abstract void checkWinner();

    public abstract void playAgainOrExit();
}
