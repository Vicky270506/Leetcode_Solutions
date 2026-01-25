class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k<2) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int left = 0; left < nums.length-k+1; left++)
        {
            ans = Math.min(ans, nums[left+k-1]-nums[left]);
        }
        return ans;
    }
}