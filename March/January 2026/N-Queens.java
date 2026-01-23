import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        solve(0, board, result, n);
        return result;
    }

    private void solve(int col, char[][] board, List<List<String>> result, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new String(board[i]));
            result.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q'; // Place Queen
                solve(col + 1, board, result, n); // Recurse
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // Check Left Row
        for (int j = 0; j < col; j++)
            if (board[row][j] == 'Q')
                return false;

        // Check Upper-Left Diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check Lower-Left Diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}