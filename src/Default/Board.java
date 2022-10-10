package Default;

public class Board {
    private int boardSize;
    private BoardCell[][] board;

    public Board() {}

    public Board(int boardSize) {
        this.setBoardSize(boardSize);
        this.initializeBoard(boardSize);
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void initializeBoard(int boardSize) {
        int i,j;
        this.board = new BoardCell[boardSize][boardSize];
        for(i = 0; i<boardSize; i++) {
            for(j = 0; j<boardSize; j++) {
                board[i][j] = new BoardCell(' ');
            }
        }
    }

    public BoardCell[][] getBoard() {
        return this.board;
    }

    public void printBoard() {
        int i, j;
        int count = 0;
        char cellPiece;
        String temp;
        StringBuilder topBottomBoard = new StringBuilder("");

        System.out.println("\n[Output]");
        
        for(i = 0; i < boardSize; i++) {
            topBottomBoard.append("+-------");
        }
        topBottomBoard.append("+");

        for (i = 0; i < boardSize; i++) {
            System.out.println("\n"+topBottomBoard);
            for(j = 0; j < boardSize; j++) {
                count++;
                cellPiece = this.board[i][j].getCellPiece();
                if(cellPiece == ' ') {
                    temp = Integer.toString(count);
                    if(temp.length() == 1) {
                        System.out.print("|   "+ Integer.toString(count) +"   ");
                    }
                    else if(temp.length() == 2) {
                        System.out.print("|  "+ Integer.toString(count) +"   ");
                    }
                    else {
                        System.out.print("|  "+ Integer.toString(count) +"  ");
                    }
                }
                else {
                    System.out.print("|   "+ cellPiece +"   ");
                } 
            }
            System.out.print("|");
        }
        System.out.println("\n"+topBottomBoard+"\n");
    }

    public void updateBoard(int position, char playerMarker) {
        int rowNumber = positionToIndex(position)[0];
        int columnNumber = positionToIndex(position)[1];
        this.board[rowNumber-1][columnNumber-1].setCellPiece(playerMarker);
    }

    public boolean isValidMove(int position) {
        if(position > (this.boardSize * this.boardSize) || position < 1) { return false; }
        int rowNumber = positionToIndex(position)[0];
        int columnNumber = positionToIndex(position)[1];
        if(board[rowNumber-1][columnNumber-1].getCellPiece() != ' ') { return false; }
        return true;
    }

    // Mapping the position number to the respective row and column numbers
    public Integer[] positionToIndex(int position) {
        Integer index[] = {0, 0};
        index[0] = (int)Math.ceil(position*1.0 / this.boardSize);
        index[1] = position % this.boardSize;
        if(index[1] == 0) { index[1] = this.boardSize; }
        return index;
    }

}
