class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        int l = bottomLeft.length;
        for(int i=0;i<l;i++)
        {
            int currentMax = 0;
            for(int j=i+1;j<l;j++)
            {
                int overlapx = Math.max(0, Math.min(topRight[j][0],topRight[i][0]) - Math.max(bottomLeft[j][0], bottomLeft[i][0]));
                int overlapy = Math.max(0, Math.min(topRight[j][1],topRight[i][1]) - Math.max(bottomLeft[j][1], bottomLeft[i][1]));
                currentMax = Math.min(overlapx, overlapy);
                ans = Math.max(ans, currentMax);

            }
        }
        return ans*ans;
    }
}