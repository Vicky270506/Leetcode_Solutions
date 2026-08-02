from functools import lru_cache

class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        self.nums = nums

        @lru_cache(None)
        def score(left, right):
            if left > right:
                return 0
            return max(
                nums[left]  - score(left + 1, right),
                nums[right] - score(left, right - 1)
            )

        return score(0, len(nums) - 1) >= 0