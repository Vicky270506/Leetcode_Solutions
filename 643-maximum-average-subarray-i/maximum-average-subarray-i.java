class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double ans = -Float.MAX_VALUE; double a = 0;
        while( left != nums.length)
        {
            if (left < k)
            {   
                a += nums[left];
            }
            else
            {
                ans = Math.max(ans, a/k);
                a -= nums[left-k];
                a += nums[left];
            }
            left += 1;
        }
        return Math.max(ans, a/k);
    }
}