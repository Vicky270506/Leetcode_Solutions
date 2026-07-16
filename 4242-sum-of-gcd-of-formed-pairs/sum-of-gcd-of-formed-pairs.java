class Solution {
    public long gcdSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int maxElement = nums[0];
        for(int i=1;i<n;i++)
        {
            maxElement = nums[i] > maxElement ? nums[i] : maxElement;
            prefix[i] = computeGCD(maxElement, nums[i]);
        }
        Arrays.sort(prefix);
        int left = 0, right = n-1;
        while(left<right)
        {
            ans += computeGCD(prefix[left++], prefix[right--]);
        }
        return ans;
    }
    private int computeGCD(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        return computeGCD(b, a%b);
    }
}