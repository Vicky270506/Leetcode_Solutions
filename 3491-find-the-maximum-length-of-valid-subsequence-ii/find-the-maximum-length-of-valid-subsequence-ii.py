class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        N = len(nums)
        for i in range(N):
            nums[i] %= k
            best = 0
        # solve for every "value" from to k 1 inclusive
        for v in range(k):
        # longest [i] subsequence where the last element is i
            longest  = [0] * k
            # value has to be vi
            for x in nums:
                prev = (v  - x) % k
                longest[x] = max(longest[x], longest[prev] + 1)
            best = max(best, max(longest))
        return best
        
        