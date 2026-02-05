class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int val = Math.abs(nums[i]);
            if(nums[i]==0)
            {
                result[i] = 0;
            }
            else if(nums[i] > 0)
            {
                val %= n;
                if(val+i >= n)
                {
                    val -= n;
                }
                result[i] = nums[val+i];
            }
            else
            {
                val%=n;
                if(i-val < 0)
                {
                    val -= n;
                }
                result[i] = nums[i-val];
            }
        }
        return result;
    }
}