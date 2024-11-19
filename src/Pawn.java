public class Pawn extends ChessPiece {

    // Конструктор, инициализирующий цвет пешки
    public Pawn(String color) {
        super(color);
    }

    // Метод для получения цвета пешки
    @Override
    public String getColor() {
        return this.color;
    }

    // Метод для проверки, может ли пешка переместиться на указанную позицию
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что целевые координаты находятся в пределах доски
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Определение направления движения пешки в зависимости от ее цвета
        int direction = this.color.equals("White") ? 1 : -1;
        // Начальная позиция пешки в зависимости от цвета
        int startLine = this.color.equals("White") ? 1 : 6;

        // Пешка может двигаться на одну клетку вперед, если она не занята
        if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (line + direction == toLine) {
                return true;
            }
            // Пешка может двигаться на две клетки вперед, если она находится на стартовой позиции и путь свободен
            if (line == startLine && line + 2 * direction == toLine && chessBoard.board[line + direction][column] == null) {
                return true;
            }
        }

        // Пешка может атаковать фигуру противника по диагонали
        if (Math.abs(column - toColumn) == 1 && line + direction == toLine) {
            if (chessBoard.board[toLine][toColumn] != null &&
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                return true;
            }
        }

        // Если ни одно из условий не выполнено, движение недопустимо
        return false;
    }

    // Метод для получения символа, представляющего пешку на доске
    @Override
    public String getSymbol() {
        return "P";
    }
}


