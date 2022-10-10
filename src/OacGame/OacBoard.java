package OacGame;

import Default.Board;
import Default.BoardCell;

public class OacBoard extends Board {

    private int boardSize;
    private BoardCell[][] board;

    public OacBoard() {
        super(6); // Fixed board size
        this.boardSize = this.getBoardSize();
        this.board = this.getBoard();
    }
}
