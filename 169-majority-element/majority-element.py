class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        c = collections.Counter(nums)
        s = dict(sorted(c.items(), key=lambda item: item[1], reverse = True))
        return next(iter(s.keys()))