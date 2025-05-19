class Solution:
    def triangleType(self, nums: List[int]) -> str:
        one,two,three = nums[0]+nums[1],nums[1]+nums[2],nums[0]+nums[2]
        if (one > nums[2]) and (two > nums[0]) and (three > nums[1]):
            if(nums[0]==nums[1]):
                if(nums[0]==nums[2]):
                    return "equilateral"
                else:
                    return "isosceles"
            elif nums[0]==nums[2]:
                return "isosceles"
            elif nums[1]==nums[2]:
                return "isosceles"
            else:
                return "scalene"
        else:
            return "none"