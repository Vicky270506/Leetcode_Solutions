class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        N = len(nums)
        ans = []
        temp = []
        mini = nums[0]
        for i in nums:
            if i - mini <= k:
                temp.append(i)
            else:
                ans.append(temp)
                mini = i
                temp = [i]
        ans.append(temp)
        return len(ans)