class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        l = []
        for i in range(0,len(nums)):
            if nums[i]==0:
                l.append(i)
        print(l)
        k=0
        for i in l:
            nums.pop(i-k)
            k+=1
        for i in range(k):
            nums.append(0)