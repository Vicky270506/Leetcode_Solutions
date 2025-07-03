class Solution(object):
    def kthCharacter(self, k):
        s = "a"
        while len(s) < k:
            s = self.Strfunc(s)  # Note the use of self.
        return s[k-1]
        
    def Strfunc(self, s):
        l = []
        for ch in s:
            # Convert character to its ASCII value, increment by 1, then convert back
            new_char = chr(ord(ch) + 1)
            l.append(new_char)
        news = "".join(l)
        return s + news