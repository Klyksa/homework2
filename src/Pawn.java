public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        byte pawn;
        byte startPos;
        if (this.getColor().equals("White")) {
            pawn = 1;
            startPos = 1;
        } else {
            if (!this.getColor().equals("Black")) {
                return false;
            }

            pawn = -1;
            startPos = 6;
        }

        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0) {
            if (line == toLine && column == toColumn) {
                return false;
            } else if (column == toColumn) {
                if (line + 2 * pawn == toLine && line == startPos) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                    } else {
                        return true;
                    }
                } else {
                    return line + pawn == toLine;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "P";
    }
}
