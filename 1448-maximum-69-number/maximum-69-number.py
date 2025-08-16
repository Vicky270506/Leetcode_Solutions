class Solution(object):
    def maximum69Number (self, num):
        """
        :type num: int
        :rtype: int
        """
        flag = True
        s = list(str(num))
        for ch in range(len(s)):
            if s[ch] == '6' and flag:
                s[ch] = '9'
                flag = False
        return int("".join(s))
                
        