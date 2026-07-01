class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            int b = target - a;
            int left = i+1;
            int right = nums.length-1;
            while(left <= right)
            {
                int mid = (int)((left + right)/2);
                if(b == nums[mid])
                {
                    return new int[]{i+1,mid+1};
                }
                else if(nums[mid] > b)
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
        }
        return new int[]{};
    }
}