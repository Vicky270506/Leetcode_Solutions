class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        self.nums = nums
        return self.score(0, len(nums) - 1) >= 0

    def score(self, left: int, right: int) -> int:
        if left > right:
            return 0
        return max(
            self.nums[left]  - self.score(left + 1, right),
            self.nums[right] - self.score(left, right - 1)
        )