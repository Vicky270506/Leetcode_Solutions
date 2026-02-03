class Solution {
    public boolean isTrionic(int[] nums) {
        int count = 0;
        boolean flag = false;
        if(nums[0] >= nums[1]) return false;
        for(int i=2;i<nums.length;i++)
        {
            if(flag == false && nums[i]<nums[i-1])
            {
                flag = true;
                count++;
            }
            if(flag == true && nums[i]>nums[i-1])
            {
                flag = false;
                count++;
            }
            if(nums[i] == nums[i-1]) return false;
            if(count > 2)
            {
                return false;
            }
        }
        return count == 2 ? true : false;
    }
}