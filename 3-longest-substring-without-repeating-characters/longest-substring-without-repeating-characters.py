class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not len(s):
            return 0
        subtr = s[0]
        m = 1
        ans = 1
        for i in range(1,len(s)):
            val = subtr.find(s[i])
            if val == -1:
                subtr += s[i]
                m += 1
            else:
                print(subtr)
                subtr = s[s[:i].rfind(s[i])+1:i+1]
                m = len(subtr)
                print(subtr)
            ans = max(ans, m)
        return ans