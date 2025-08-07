class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int diagonal = 0, n = fruits.length;
        for(int i=0;i<n;i++)
        {
            diagonal += fruits[i][i];
            fruits[i][i] = -Integer.MIN_VALUE;
        }
        fruits[n-1][n-1] = 0;

        //From Index 0,N-1
        int[][] dp = new int[n][n];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][n-1] = fruits[0][n-1];
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int dj=-1;dj<=1;dj++)
                {
                    if (0 <= j+dj && j+dj < n)
                    {
                        dp[i][j] = fmax(dp[i][j], dp[i-1][j+dj] + fruits[i][j]);
                    }
                }
            }
        }
        int a = dp[n-1][n-1];

        //From Index N-1,0
        int[][] dp2 = new int[n][n];
        for(int i=0;i<dp2.length;i++)
            Arrays.fill(dp2[i], Integer.MIN_VALUE);
        dp2[n-1][0] = fruits[n-1][0];
        
        for(int j=1;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                for(int di=-1;di<=1;di++)
                {
                    if(0 <= i+di && i+di < n)
                    {
                        dp2[i][j] = fmax(dp2[i][j], dp2[i+di][j-1]+fruits[i][j]); 
                    }
                }
            }

        }
        int b = dp2[n-1][n-1];
        return diagonal+a+b;
    }
    private int fmax(int a, int b)
    {
        return a>b ? a : b;
    }
}