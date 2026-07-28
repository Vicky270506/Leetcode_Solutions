class Solution:
    def smallestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        
        n = len(s) // 2 if len(s)%2 == 0 else (len(s) - 1) // 2
        c = s[:n]
        t = self.getSortedString(c)
        if len(s) % 2 == 0:
            return t + t[::-1]
        else:
            return t + s[len(s) // 2] + t[::-1]
        
    def getSortedString(self, s: str) -> str:
        l = []
        for i in s:
            l.append(i)
        
        l.sort()
        return "".join(l)