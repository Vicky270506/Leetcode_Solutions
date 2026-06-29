class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i-1 == 0 || j-1 == 0)
                {
                    dp[i][j] = grid[i-1][j-1] + Math.max(dp[i-1][j], dp[i][j-1]);
                }
                else
                {
                    dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}