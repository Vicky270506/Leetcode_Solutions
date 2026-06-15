class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
        {
            return true;
        }
        int n = nums.length-1;
        int prev = 0;

        for(int i=0;i<n;i++)
        {
            if(nums[i] == 0 && prev == 0)
            {
                return false;
            }
            
            prev = prev < nums[i] ? nums[i] : prev;
            prev--;
        }
        return true;
    }
}