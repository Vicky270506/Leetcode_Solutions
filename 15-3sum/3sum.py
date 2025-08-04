class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        
        for i in range(len(nums)):
            # Skip duplicates for the first element
            if i > 0 and nums[i] == nums[i-1]:
                continue
                
            left, right = i+1, len(nums)-1
            
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    
                    # Skip duplicates for left pointer
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                    
                    # Skip duplicates for right pointer
                    while left < right and nums[right] == nums[right+1]:
                        right -= 1
                        
                elif sum > 0:
                    right -= 1
                else:
                    left += 1
        
        return result