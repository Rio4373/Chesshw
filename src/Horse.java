public class Horse extends ChessPiece {

    // Конструктор, инициализирующий цвет коня
    public Horse(String color) {
        super(color);
    }

    // Метод для получения цвета коня
    @Override
    public String getColor() {
        return this.color;
    }

    // Метод для проверки, может ли конь переместиться на указанную позицию
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что начальная и конечная позиции находятся в пределах доски
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Проверка, что начальная и конечная позиции не совпадают
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Вычисление разницы по строкам и столбцам
        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);

        // Проверка, что движение соответствует "Г"-образной траектории (2 клетки в одном направлении и 1 в другом)
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            // Проверка, что в конечной позиции либо нет фигуры, либо стоит фигура другого цвета
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        // Если движение не соответствует "Г"-образной форме, оно недопустимо
        return false;
    }

    // Метод для получения символа, представляющего коня на доске
    @Override
    public String getSymbol() {
        return "H";
    }
}

