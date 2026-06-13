class Solution {
    public int climbStairs(int n) {
        int ans = 0;
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            if(i<=1)
            {
                arr[i] = 1;
            }
            else
            {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[n];
    }
}