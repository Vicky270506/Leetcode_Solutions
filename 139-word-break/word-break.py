class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        n = len(s)
        dp = [False] * (n + 1)

        # empty string is always breakable
        dp[n] = True

        # fill from back to front
        for i in range(n - 1, -1, -1):
            for word in wordDict:
                if i + len(word) <= n and s[i:i+len(word)] == word:
                    if dp[i + len(word)]:
                        dp[i] = True
                        break

        return dp[0]
        