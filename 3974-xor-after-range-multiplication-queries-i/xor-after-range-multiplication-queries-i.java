class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = (int)Math.pow(10,9) + 7;

        for(int[] a: queries)
        {
            int idx = a[0];
            int v = a[3], r = a[1], k = a[2];
            while(idx <= r)
            {
                nums[idx] = (int)(((long)nums[idx] * v) % MOD);
                idx += k;
            }
        }
        if(nums.length == 1)
        {
            return nums[0];
        }
        int ans = nums[0] ^ nums[1];
        for(int i=2;i<nums.length;i++)
        {
            ans ^= nums[i];
        }
        return ans;
    }
}