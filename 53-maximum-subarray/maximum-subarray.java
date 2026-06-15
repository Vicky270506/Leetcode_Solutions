class Solution {
    public int maxSubArray(int[] nums) {
        int m = 0, maxsum = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            m += nums[i];
            maxsum = Math.max(maxsum, m);
            if(m < 0)
            {
                m = 0;
            }
        }
        return maxsum;
    }
}