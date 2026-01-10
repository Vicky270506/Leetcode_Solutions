class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        N1 = len(s1)
        N2 = len(s2)
        INF = 10 ** 20

        @cache
        def dp(index1, index2):
            if index1 == N1 and index2 == N2:
                return 0
            
            if index1 == N1:
                return dp(index1, index2 + 1) + ord(s2[index2])
            
            if index2 == N2:
                return dp(index1 + 1, index2) + ord(s1[index1])
            
            best = INF

            #delete both if they are same
            if s1[index1] == s2[index2]:
                best = min(best, dp(index1 + 1, index2 +1))
            
            #delete first from either
            best = min(best, dp(index1 + 1,index2) + ord(s1[index1]))

            best = min(best, dp(index1, index2 + 1) + ord(s2[index2]))

            print(best)

            return best
        
        return dp(0,0)