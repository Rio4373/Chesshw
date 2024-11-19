public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);

        // Проверка "Г" формы движения коня
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            // Проверка, что в конечной позиции нет фигуры того же цвета
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
