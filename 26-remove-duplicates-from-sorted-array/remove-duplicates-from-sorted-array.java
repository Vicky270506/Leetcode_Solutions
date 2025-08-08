class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;++i)
        {
            if(nums[i]!=prev)
            {
                nums[k++] = nums[i];
                prev = nums[i];
            }
        }
        return k;
    }
}