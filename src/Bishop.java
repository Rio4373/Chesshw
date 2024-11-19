public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            int stepLine = (toLine - line) > 0 ? 1 : -1;
            int stepColumn = (toColumn - column) > 0 ? 1 : -1;
            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            while (currentLine != toLine && currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += stepLine;
                currentColumn += stepColumn;
            }

            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}


