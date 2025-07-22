class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        l = []
        res = 0
        for n in nums:
            if n not in l:
                l.append(n)
            else:
                res = max(sum(l),res)
                id = l.index(n)
                l = l[id+1:]
                l.append(n)
        res = max(sum(l),res)
        return res