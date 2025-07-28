class Solution(object):
    def countMaxOrSubsets(self, nums):
        def calcSubsets(n, nums, M):
            o = []
            for i in range(1 << n):
                l = []
                sum_or = 0
                for j in range(n):
                    if (i & (1 << j)) != 0:
                        l.append(nums[j])
                for num in l:
                    sum_or |= num
                if sum_or == M:
                    o.append(l)
            return len(o)
        
        N = len(nums)
        sum_or = 0
        for num in nums:
            sum_or |= num
        
        return calcSubsets(N, nums, sum_or)