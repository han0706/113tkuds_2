class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // 初始化已填數字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        backtrack(board, 0, 0, rows, cols, boxes);
    }

    private boolean backtrack(char[][] board, int i, int j, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        if (i == 9) return true; // 填完所有行

        int nextI = (j == 8) ? i + 1 : i;
        int nextJ = (j + 1) % 9;

        if (board[i][j] != '.') return backtrack(board, nextI, nextJ, rows, cols, boxes);

        int boxIndex = (i / 3) * 3 + (j / 3);
        for (int num = 0; num < 9; num++) {
            if (!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]) {
                board[i][j] = (char) (num + '1');
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;

                if (backtrack(board, nextI, nextJ, rows, cols, boxes)) return true;

                // 回溯
                board[i][j] = '.';
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = false;
            }
        }

        return false; // 該位置無解
    }
}
