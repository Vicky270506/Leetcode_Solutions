class Solution:
    def sumAndMultiply(self, n: int) -> int:
        ans = 0
        s = 0
        for i in str(n):
            if i != '0':
                ans = (ans*10) + int(i)
                s += int(i)
        return ans*s