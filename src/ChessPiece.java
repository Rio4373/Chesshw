// Абстрактный класс, представляющий шахматную фигуру.
public abstract class ChessPiece {
    // Цвет фигуры (например, "White" или "Black").
    protected String color;

    // Флаг, указывающий, двигалась ли фигура хотя бы раз.
    private boolean hasMoved;

    // Конструктор для инициализации шахматной фигуры с заданным цветом.
    public ChessPiece(String color) {
        this.color = color;
        this.hasMoved = false; // Изначально фигура не двигалась.
    }

    // Метод для получения цвета фигуры.
    public String getColor() {
        return color;
    }

    // Абстрактный метод, который должен быть реализован в подклассах
    // для определения возможности перемещения фигуры на заданную позицию.
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    // Абстрактный метод, который должен быть реализован в подклассах
    // для возврата символа, представляющего фигуру.
    public abstract String getSymbol();

    // Метод для проверки, двигалась ли фигура.
    public boolean hasMoved() {
        return hasMoved;
    }

    // Метод для установки флага, указывающего на то, что фигура двигалась.
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}



