class Solution {
    public int[] twoSum(int[] nums, int target) {
        int val = 0;
        for(int i = 0; i<nums.length; ++i)
        {
            val = target - nums[i];
            for(int j = i+1; j<nums.length; ++j)
            {
                if(nums[j]==val)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}