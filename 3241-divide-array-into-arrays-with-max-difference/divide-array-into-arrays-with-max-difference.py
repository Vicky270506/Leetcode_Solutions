class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        N = len(nums)
        ans = []
        nums.sort()
        for i in range(0,N,3):
            if nums[i+2] - nums[i] <= k:
                ans.append([nums[i],nums[i+1],nums[i+2]])
            else:
                return []
        return ans