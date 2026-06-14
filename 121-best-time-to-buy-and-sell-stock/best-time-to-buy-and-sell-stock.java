class Solution {
    public int maxProfit(int[] prices) {
        int b = Integer.MAX_VALUE, s = 0;
        int m = 0;

        for(int i=0;i<prices.length; i++)
        {
            int v = prices[i];
            if(v < b)
            {
                b = v;
                s = v;
            }
            if( v > s)
            {
                s = v;
            }
            m = Math.max(m, s - b);
        }
        return m;
    }
}