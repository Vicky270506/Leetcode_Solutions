class Solution {
    public boolean check(int[] nums) {
        int limit = 0;

        for (int i=1;i<nums.length; i++)
        {
            if(nums[i] < nums[i-1])
            {
                if(limit == 0)
                {
                    limit += 1;
                }
                else
                {
                    return false;
                }
            }
        }
        if(nums[0] < nums[nums.length-1] && limit != 0) return false;
        return true;
    }
}