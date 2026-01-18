class Solution {
    int[][] mat;
    int m, n;

    public int largestMagicSquare(int[][] grid) {
        this.mat = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int maxSize = Math.min(m, n);

        // Try larger squares first
        for (int c = maxSize; c > 1; c--) {
            for (int i = 0; i + c <= m; i++) {
                for (int j = 0; j + c <= n; j++) {
                    if (isMagic(i, j, c)) {
                        return c;
                    }
                }
            }
        }
        return 1; // Every 1x1 grid is magic
    }

    private boolean isMagic(int r, int c, int size) {
        int target = rowSum(c, c + size, r);

        // Check all rows
        for (int i = r; i < r + size; i++) {
            if (rowSum(c, c + size, i) != target) {
                return false;
            }
        }

        // Check all columns
        for (int j = c; j < c + size; j++) {
            if (columnSum(r, r + size, j) != target) {
                return false;
            }
        }

        // Check diagonals
        if (ldiagonalSum(r, c, size) != target) return false;
        if (rdiagonalSum(r, c + size - 1, size) != target) return false;

        return true;
    }

    private int rowSum(int start, int end, int row) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += mat[row][i];
        }
        return sum;
    }

    private int columnSum(int start, int end, int col) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += mat[i][col];
        }
        return sum;
    }

    private int ldiagonalSum(int i, int j, int size) {
        int sum = 0;
        while (size-- > 0) {
            sum += mat[i++][j++];
        }
        return sum;
    }

    private int rdiagonalSum(int i, int j, int size) {
        int sum = 0;
        while (size-- > 0) {
            sum += mat[i++][j--];
        }
        return sum;
    }
}
