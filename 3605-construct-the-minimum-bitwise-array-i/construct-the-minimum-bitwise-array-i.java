class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0;i<nums.size();i++)
        {
            ans[i] = findValue(nums.get(i));
        }
        return ans;
    }
    private int findValue(int n)
    {
        for(int i=1;i<n;i++)
        {
            int sum = i | (i+1);
            if(sum==n)
            {
                return i;
            }
        }
        return -1;
    }
}