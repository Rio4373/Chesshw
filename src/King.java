// Класс King представляет шахматную фигуру короля.
public class King extends ChessPiece {

    // Конструктор инициализирует короля заданным цветом.
    public King(String color) {
        super(color);
    }

    // Метод для получения цвета короля.
    @Override
    public String getColor() {
        return this.color;
    }

    // Метод для проверки, может ли король переместиться на указанную позицию.
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка, что целевые координаты находятся в пределах доски.
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Король может двигаться на одну клетку в любом направлении.
        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            // Проверка, что конечная позиция или пуста, или занята фигурой противника.
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        // Если движение не соответствует правилам короля, оно недопустимо.
        return false;
    }

    // Метод для получения символа, представляющего короля на доске.
    @Override
    public String getSymbol() {
        return "K";
    }

    // Метод для проверки, находится ли король под атакой на указанной позиции.
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        // Проход по всем клеткам доски для проверки, может ли фигура противника атаковать короля.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessBoard.board[i][j];
                // Если фигура противника может переместиться на позицию короля, возвращаем true.
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        // Если ни одна фигура противника не угрожает позиции короля, возвращаем false.
        return false;
    }
}


