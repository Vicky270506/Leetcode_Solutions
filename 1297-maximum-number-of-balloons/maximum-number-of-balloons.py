class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        d = collections.Counter(text)

        b = {'b' : 0, 'a': 0, 'l': 0, 'o': 0, 'n': 0}
        ans = 10 ** 5

        for i,j in d.items():
            if i in b.keys():
                b[i] += j
        
        for i, j in b.items():
            if i in ['a', 'b', 'n']:
                ans = min(ans, j)
            else:
                ans = min(ans, j//2)
        
        return ans