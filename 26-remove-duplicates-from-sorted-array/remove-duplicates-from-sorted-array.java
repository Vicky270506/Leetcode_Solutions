class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; int index = 1;
        int id = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if( id != nums[i])
            {
                id = nums[i];
                k++;
                nums[index] = id;
                index++;
            }
        }
        return k+1;
    }
}