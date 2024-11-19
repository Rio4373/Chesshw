public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn];
                board[startLine][startColumn] = null;
                board[endLine][endColumn].setHasMoved(true); // Отметить фигуру как перемещенную
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        int row = nowPlayerColor().equals("White") ? 0 : 7;
        int rookColumn = 0;
        int kingColumn = 4;

        if (canCastle(row, kingColumn, rookColumn)) {
            performCastle(row, kingColumn, rookColumn, 3);
            return true;
        }
        return false;
    }

    public boolean castling7() {
        int row = nowPlayerColor().equals("White") ? 0 : 7;
        int rookColumn = 7;
        int kingColumn = 4;

        if (canCastle(row, kingColumn, rookColumn)) {
            performCastle(row, kingColumn, rookColumn, 5);
            return true;
        }
        return false;
    }

    private boolean canCastle(int row, int kingColumn, int rookColumn) {
        if (board[row][kingColumn] instanceof King && board[row][rookColumn] instanceof Rook) {
            King king = (King) board[row][kingColumn];
            Rook rook = (Rook) board[row][rookColumn];

            if (!king.hasMoved() && !rook.hasMoved()) {
                int min = Math.min(kingColumn, rookColumn);
                int max = Math.max(kingColumn, rookColumn);
                for (int i = min + 1; i < max; i++) {
                    if (board[row][i] != null) {
                        return false;
                    }
                }
                return !king.isUnderAttack(this, row, kingColumn);
            }
        }
        return false;
    }

    private void performCastle(int row, int kingColumn, int rookColumn, int newKingColumn) {
        board[row][newKingColumn] = board[row][kingColumn];
        board[row][kingColumn] = null;
        board[row][newKingColumn].setHasMoved(true);

        int newRookColumn = (rookColumn < kingColumn) ? newKingColumn - 1 : newKingColumn + 1;
        board[row][newRookColumn] = board[row][rookColumn];
        board[row][rookColumn] = null;
        board[row][newRookColumn].setHasMoved(true);

        this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
    }
}
