class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0 || nums.length < 2)
        {
            return false;
        }
        else if(nums[0] == nums[1])
        {
            return true;
        }
        int left = 0;
        int right = 1;
        while(left < nums.length-2)
        {
            if(right-left > k || right == nums.length)
            {
                left++;
                right = left+1;
            }
            
            if(nums[left] == nums[right] && left != right)
            {
                return true;
            }
            else
            {
                right++;
            }
        }
        return false;
    }
}