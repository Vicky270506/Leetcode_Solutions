class Solution {
    public boolean isTrionic(int[] nums) {
        int flag = 0;
        if(nums.length < 4)
                return false;
        for(int i=1;i<nums.length;i++)
            {
                if(nums[i]==nums[i-1]) return false;
                if(flag == 0 && nums[i]<nums[i-1])
                {
                    flag++;
                }
                else if(flag==1 && nums[i-1]<nums[i])
                {
                    flag++;
                }
                else if(nums[0]>=nums[1])
                {
                    return false;
                }
                else if(flag == 2 && nums[i]<nums[i-1])
                    return false;
            }
        if(flag==2)
            return true;
        else
            return false;
    }
}