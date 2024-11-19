public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int direction = this.color.equals("White") ? 1 : -1;
        int startLine = this.color.equals("White") ? 1 : 6;

        // Пешка может двигаться на одну клетку вперед
        if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (line + direction == toLine) {
                return true;
            }
            // Пешка может двигаться на два поля вперед с начальной позиции
            if (line == startLine && line + 2 * direction == toLine && chessBoard.board[line + direction][column] == null) {
                return true;
            }
        }

        // Пешка может атаковать фигуру по диагонали
        if (Math.abs(column - toColumn) == 1 && line + direction == toLine) {
            if (chessBoard.board[toLine][toColumn] != null &&
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}


