class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0, right=nums.length-1, k=0;
        if(!Arrays.stream(nums).findAny().isPresent()) return 0;
        while(left<=right)
        {
            if(nums[left]==val && nums[right]!=val)
            {
                nums[left]=nums[right];
                left++;
                right--;k+=1;
            }
            else if( nums[right]==val)
            {
                right--;k+=1;
            }
            else if( nums[left]!=val)
            {
                left++;
            }
            
        }
        return nums.length-k;
    }
}