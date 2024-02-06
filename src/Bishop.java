public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return line != toLine && 0 <= toLine && toLine < 8 && 0 <= toColumn && toColumn < 8 && Math.abs(toLine - line) == Math.abs(toColumn - column);
    }

    public String getSymbol() {
        return "B";
    }
}
