public class King extends ChessPiece {
    boolean isUnderAttack = false;

    public King(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0) {
            if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
                if (this.isUnderAttack(chessBoard, toLine, toColumn)) {
                    return false;
                } else if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for(int x = 0; x < 7; ++x) {
            for(int y = 0; y < 7; ++y) {
                if (chessBoard.board[x][y] != null && !chessBoard.board[x][y].getColor().equals(this.color) && chessBoard.board[x][y].canMoveToPosition(chessBoard, x, y, line, column)) {
                    return false;
                }
            }
        }

        return this.isUnderAttack;
    }

    public String getSymbol() {
        return "K";
    }
}
