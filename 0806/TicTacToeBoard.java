import java.util.*;

public class TicTacToeBoard {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        for (char[] row : board) Arrays.fill(row, ' ');
        place(0, 0, 'X');
        place(1, 1, 'X');
        place(2, 2, 'X');
        printBoard();
        if (checkWin('X')) System.out.println("X wins");
        else if (isFull()) System.out.println("Draw");
        else System.out.println("Game continues");
    }

    static boolean place(int r, int c, char p) {
        if (r < 0 || r >= 3 || c < 0 || c >= 3 || board[r][c] != ' ') return false;
        board[r][c] = p;
        return true;
    }

    static boolean checkWin(char p) {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == p && board[i][1] == p && board[i][2] == p) ||
                (board[0][i] == p && board[1][i] == p && board[2][i] == p))
                return true;
        return (board[0][0] == p && board[1][1] == p && board[2][2] == p) ||
               (board[0][2] == p && board[1][1] == p && board[2][0] == p);
    }

    static boolean isFull() {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    static void printBoard() {
        for (char[] row : board) System.out.println(Arrays.toString(row));
    }
}
