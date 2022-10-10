package Default;
import java.util.Scanner;

public class Player {

    private String playerName;
    private Integer gamesHistory[] = {0, 0}; // wins and loses
    private char playerMarker; // work with markers

    private Scanner inputMove = new Scanner(System.in);

    public Player() {}

    public Player(String playerName, char playerMarker) {
        this.setPlayerName(playerName);
        this.setGameHistory(0, 0);
        this.setPlayerMarker(playerMarker);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setGameHistory(int wins, int loses) {
        this.gamesHistory[0] = 0;
        this.gamesHistory[1] = 0;
    }

    public Integer[] getGameHistory() {
        return this.gamesHistory;
    }

    public void updateGameHistory(int wins, int loses) {
        this.gamesHistory[0] += wins;
        this.gamesHistory[1] += loses;
    }

    public void setPlayerMarker(char playerMarker) {
        this.playerMarker = playerMarker;
    }

    public char getPlayerMarker() {
        return this.playerMarker;
    }

    public int placeTheKey(Board board, char playerMarker) {
        // check if move is valid (position given by the player is an integer or not)
        // update the board
        int position = -1;
        System.out.println("[Input] >>> Please enter the cell number you would like to place the marker on: ");
        inputMove = new Scanner(System.in);
        if(inputMove.hasNextInt()) {
            position = inputMove.nextInt();
            if(board.isValidMove(position)) {
                board.updateBoard(position, playerMarker);
            }
            else {
                System.out.println("\n=== You have chosen a position which is out-of-range or already taken. Please choose another position to place the marker! ===\n");
                this.placeTheKey(board, playerMarker); // function call to the start of the move.
            }
        }
        else {
            System.out.println("\n=== You have entered an invalid input. Please enter an INTEGER! (e.g) 3/4/5 ===\n");
            this.placeTheKey(board, playerMarker);
        }
        return position;
    }
}
