class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        
        N = len(nums)
        s = {}

        for i,j in enumerate(nums):
            s[i] = j
        
        s = dict(sorted(s.items(), key=lambda item: item[1], reverse=True))

        ans = dict(list(s.items())[:k])

        sorted_dict = dict(sorted(ans.items()))
        values_list = list(sorted_dict.values())
        return values_list
