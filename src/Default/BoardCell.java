package Default;

public class BoardCell {
    char cellPiece;

    public BoardCell(char cellPiece) {
        this.setCellPiece(cellPiece);
    }

    public void setCellPiece(char cellPiece) {
        this.cellPiece = cellPiece;
    }

    public char getCellPiece() {
        return this.cellPiece;
    }
}
