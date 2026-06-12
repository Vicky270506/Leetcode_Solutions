class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for(int i=1; i<nums.length;i++)
        {
            if(nums[i] == nums[i-1])
            {
                continue;
            }
            else
            {
                swap(nums, i-1, p);
                p++;
            }
        }
        swap(nums, p, nums.length-1);
        return p+1;
    }
    private void swap(int[] nums, int a, int p)
    {
        int t = nums[a];
        nums[a] = nums[p];
        nums[p] = t;
    }
}