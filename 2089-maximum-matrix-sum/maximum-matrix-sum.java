class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minValue = (int)Math.pow(10,5);
        int nCount = 0;
        long ans = 0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]<0)
                {
                    nCount++;
                }
                minValue = Math.min(minValue, Math.abs(matrix[i][j]));
                ans += Math.abs(matrix[i][j]);
            }
        }
        System.out.println(minValue);
        System.out.println(nCount);
        if(nCount%2==0)
        {
            return ans;
        }
        else
        {
            return ans - (2 * minValue);
        }

    }
}