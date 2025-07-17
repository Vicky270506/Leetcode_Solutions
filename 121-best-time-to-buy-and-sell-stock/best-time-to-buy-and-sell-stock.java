class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, min = 0, max = 0, right = 0;
        int best = 0;
        while(right < prices.length)
        {
            if(prices[right] < prices[min])
            {
                min = right;
                max = right;
            }
            if(prices[right] > prices[max])
            {
                max = right;
            }
            right++;
            best = Math.max(best, prices[max] - prices[min]);
        }
        return best;
    }
}