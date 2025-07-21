class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        for i in range(1,len(nums)):
            if nums[i-1] > nums[i]:
                nums = nums[i:] + nums[:i]
                print(nums)
                break
        return self.binary_search(nums,target)
    
    def binary_search(self, arr, target):
        left, right = 0, len(arr) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if arr[mid] == target:
                return True
            elif target < arr[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return False
        