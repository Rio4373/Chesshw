public abstract class ChessPiece {
    protected String color;
    private boolean hasMoved;

    public ChessPiece(String color) {
        this.color = color;
        this.hasMoved = false; // Изначально фигура не двигалась
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}


