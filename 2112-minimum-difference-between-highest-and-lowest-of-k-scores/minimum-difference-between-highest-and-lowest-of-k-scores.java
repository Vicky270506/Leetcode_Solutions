class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k<2) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int left = 0; left < nums.length-k+1; left++)
        {
            int max_val = Integer.MIN_VALUE, min_val = Integer.MAX_VALUE;
            for(int i = left; i<left+k;i++)
            {
                max_val = Math.max(max_val, nums[i]);
                min_val = Math.min(min_val, nums[i]);
            }
            ans = Math.min(ans, max_val - min_val);
        }
        return ans;
    }
}