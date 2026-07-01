class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i=cost.length-2; i>=0; i--)
        {
            if(i+2 < cost.length)
                cost[i] = cost[i] + Math.min(cost[i+1], cost[i+2]);
        }
        return cost[1] < cost[0] ? cost[1] : cost[0];
    }
}