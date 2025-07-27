class Solution(object):
    def countHillValley(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        s=[]
        for i in nums:
            if len(s) == 0 or i != s[-1]:
                s.append(i)
        print(s)
        score=0
        for i in range(1,len(s)-1):
            if (s[i] > s[i+1] and s[i] > s[i-1]) or (s[i] < s[i+1] and s[i] < s[i-1]):
                score += 1
        return score
        