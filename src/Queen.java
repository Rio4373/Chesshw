// Класс Queen представляет шахматную фигуру ферзя.
public class Queen extends ChessPiece {

    // Конструктор инициализирует ферзя заданным цветом.
    public Queen(String color) {
        super(color);
    }

    // Метод для получения цвета ферзя.
    @Override
    public String getColor() {
        return this.color;
    }

    // Метод для проверки, может ли ферзь переместиться на указанную позицию.
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что целевые координаты находятся в пределах доски.
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Ферзь может двигаться по горизонтали, вертикали или диагонали.
        if (line == toLine || column == toColumn || Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            // Определение направления движения по строкам и столбцам.
            int stepLine = (toLine - line) == 0 ? 0 : (toLine - line) > 0 ? 1 : -1;
            int stepColumn = (toColumn - column) == 0 ? 0 : (toColumn - column) > 0 ? 1 : -1;

            // Инициализация текущей позиции для проверки пути.
            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            // Проверка всех клеток на пути к цели, чтобы убедиться, что они пусты.
            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false; // Если на пути есть фигура, движение невозможно.
                }
                currentLine += stepLine; // Переход к следующей строке.
                currentColumn += stepColumn; // Переход к следующему столбцу.
            }

            // Проверка, что конечная позиция или пуста, или занята фигурой противника.
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        // Если движение не соответствует правилам ферзя, оно недопустимо.
        return false;
    }

    // Метод для получения символа, представляющего ферзя на доске.
    @Override
    public String getSymbol() {
        return "Q";
    }
}


