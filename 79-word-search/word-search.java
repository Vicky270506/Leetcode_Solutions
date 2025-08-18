class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(board, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // If we've matched the entire word
        if (index == word.length()) return true;

        // Boundary and char check
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) return false;
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;

        // Choose
        visited[row][col] = true;

        // Explore neighbors: up, down, left, right
        boolean found =
            backtrack(board, word, index + 1, row - 1, col, visited) ||
            backtrack(board, word, index + 1, row + 1, col, visited) ||
            backtrack(board, word, index + 1, row, col - 1, visited) ||
            backtrack(board, word, index + 1, row, col + 1, visited);

        // Unchoose (backtrack)
        visited[row][col] = false;

        return found;
    }
}