class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                prefix[i] = nums[i];
            }
            else
            {
                prefix[i] = (nums[i] + prefix[i-1]);
            }
        }
        int ans=0;
        for(int i=prefix.length-1;i>=0;i--)
        {
            if(prefix[i] == k)
            {
                ans++;
            }
            for(int j=i-1;j>=0;j--)
            {
                if(prefix[i]-prefix[j] == k)
                {
                    ans++;
                }
            }
        }
        System.out.println(Arrays.toString(prefix));
        return ans;
    }
}