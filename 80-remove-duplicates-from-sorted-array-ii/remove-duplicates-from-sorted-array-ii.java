class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1, prev = nums[0], k = 1;
        for(int i = 1; i<nums.length; i++)
        {
            if(count<2 && prev == nums[i])
            {
                nums[k++] = nums[i];
                count++;
            }
            else if(prev != nums[i])
            {
                prev = nums[i];
                count = 1;
                nums[k++] = nums[i];

            }
        }
        return k;
    }
}