class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            maximalSquare(new char[][]{});
        }
    }
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans = -1;

        for(int i=1;i<=m;i++)
        {
            dp[i][1] = matrix[i-1][0] - '0';
            ans = Math.max(ans, dp[i][1]);
        }

        for(int j=1;j<=n;j++)
        {
            dp[1][j] = matrix[0][j-1] - '0';
            ans = Math.max(ans, dp[1][j]);
        }

        for(int i=2;i<=m;i++)
        {
            for(int j=2;j<=n;j++)
            {
                if(matrix[i-1][j-1] != '0')
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        
        return ans*ans;
    }
}