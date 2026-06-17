class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();

        for(int i =0 ; i<matrix.length;i++)
        {
            for(int j=0; j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(!rows.contains(i))
                    {
                        rows.add(i);
                    }
                    if(!cols.contains(j))
                    {
                        cols.add(j);
                    }
                }
            }
        }
        for(int i:rows)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j] = 0;
            }
        }
        for(int j: cols)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][j] = 0;
            }
        }
        System.gc();
    }
}