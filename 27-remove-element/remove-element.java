class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            if (nums[left] == val)
            {
                while(nums[right]==val && right>left)
                {
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
           left++;
        }
        System.out.print(Arrays.toString(nums));
        left = 0;
        for(int n: nums)
        {
            if(n==val)
                break;
            left++;
        }
        System.out.print(Arrays.toString(nums));

        return left;
    }
}