class Solution(object):
    def numberOfWays(self, N, X):
        """
        :type n: int
        :type x: int
        :rtype: int
        """
        MOD = 10 ** 9 + 7
        dp = [0] * (N+1)
        dp[0] = 1

        for i in range(1, N+1):
            val = i**X

            if val > N:
                break
            
            for j in range(N,val-1,-1):
                dp[j] = (dp[j] + dp[j-val])
        print(dp)
        return dp[N] % MOD

        