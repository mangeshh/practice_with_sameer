package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
@SuppressWarnings("unused")
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < n; ++row) {
            Arrays.fill(board[row], '.');
        }
        backtrack(0, board, solutions);
        return solutions;
    }

    public void backtrack(int currentRow, char[][] board, List<List<String>> solutions) {
        if (currentRow == board.length) {
            List<String> currentSolution = new ArrayList<>();
            for (char[] row : board) {
                currentSolution.add(new String(row));
            }
            solutions.add(currentSolution);
            return;
        }

        for (int currentCol = 0; currentCol < board[currentRow].length; ++currentCol) {
            if (isValid(currentRow, currentCol, board)) {
                board[currentRow][currentCol] = 'Q';
                backtrack(currentRow + 1, board, solutions);
                board[currentRow][currentCol] = '.';
            }
        }
    }

    public boolean isValid(int currentRow, int currentCol, char[][] board) {

        for (int col = 0; col < board.length; col++) {
            if (board[currentRow][col] == 'Q') {
                return false;
            }
        }

        for (int row = 0; row < board.length; ++row) {
            if (board[row][currentCol] == 'Q') {
                return false;
            }
        }

        for (int distance = 1; distance < board.length; ++distance) {
            if (currentRow + distance < board.length && currentCol + distance < board.length) {
                if (board[currentRow + distance][currentCol + distance] == 'Q') {
                    return false;
                }
            }
            if (currentRow + distance < board.length && currentCol - distance >= 0) {
                if (board[currentRow + distance][currentCol - distance] == 'Q') {
                    return false;
                }
            }
            if (currentRow - distance >= 0 && currentCol + distance < board.length) {
                if (board[currentRow - distance][currentCol + distance] == 'Q') {
                    return false;
                }
            }
            if (currentRow - distance >= 0 && currentCol - distance >= 0) {
                if (board[currentRow - distance][currentCol - distance] == 'Q') {
                    return false;
                }
            }
        }

        return true;
    }
}
