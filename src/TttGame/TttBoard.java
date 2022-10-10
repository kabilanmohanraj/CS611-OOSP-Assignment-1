package TttGame;

import Default.Board;
import Default.BoardCell;

public class TttBoard extends Board {

    private int boardSize;
    private BoardCell[][] board;

    public TttBoard() {}

    public TttBoard(int boardSize) {
        super(boardSize); // initialize parent class constructor
        this.boardSize = this.getBoardSize();
        this.board = this.getBoard();
    } 
}
