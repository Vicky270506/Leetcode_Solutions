class Solution {
    public int fib(int n) {
        if(n < 2)
        {
            return n;
        }
        int f = 0, k = 1;
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            ans = f + k;
            k = f;
            f = ans;
        }
        return ans;
    }
}