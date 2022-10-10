package Default;

import java.util.Scanner;

import OacGame.OacGameDriver;
import TttGame.TttGameDriver;

public class GameSelector {
    // private enum gameMenu {Tic_Tac_Toe, Order_and_Chaos};
    private String[] gameMenu = {"Tic Tac Toe", "Order and Chaos"};

    public void show() {
        this.gameMenuDisplay();
    }

    private void gameMenuDisplay() {
        int itemNumber;
        for (itemNumber=0; itemNumber<gameMenu.length; itemNumber++) {
            System.out.println("["+Integer.toString(itemNumber+1)+"]  "+gameMenu[itemNumber]);
        }

        System.out.print("\n[Input] Choose game to play: ");
        Scanner input = new Scanner(System.in);
        gameInitiator(input.next());
        input.close();
    }

    private void gameInitiator(String gameChoice) {
        switch (gameChoice) {
            case "1":
                System.out.println("\nStarting Tic Tac Toe! Please note the following.\n");
                System.out.println();
                System.out.println("    1. Player 1 will always begin first. Player 1's assigned marker is 'X' and Player 2's is 'O'");
                System.out.println("    2. Chosen size of the board can only be from 3x3 to 10x10.");
                System.out.println();

                new TttGameDriver().startGame();
                break;
            case "2":
                System.out.println("\nStarting Order and Chaos! Please note the following.\n");
                System.out.println();
                System.out.println("    1. Player 1 will play 'Order' and Player 2 will play 'Chaos'.");
                System.out.println("    2. Order plays first.");
                System.out.println("    3. The size of the board is fixed to be 6x6.");
                System.out.println("    4. Winning condition >>> 'Order' wins when there are 5 continuous markers (6 continuous markers is not a win for Order and the game will continue till 5 consecutive markers are placed). And 'Chaos' wins when the board is filled with no 5 continuous markers of 'X's or 'O's.");
                System.out.println();

                new OacGameDriver().startGame();
                break;
            default:
                System.out.println("\nPlease choose one of the available options...\n");
                this.gameMenuDisplay();
        }
    }
    
}
