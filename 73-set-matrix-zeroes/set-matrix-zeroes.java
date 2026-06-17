class Solution {
    public void setZeroes(int[][] matrix) {
        int r = -1;
        int c = -1;
        for(int i =0 ; i<matrix.length;i++)
        {
            for(int j=0; j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(j==0)
                    {
                        r = 0;
                    }
                    else if(i==0)
                    {
                        c = 0;
                    }
                    else
                    {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }        
        }
        if(matrix[0][0] == 0)
        {
            for(int i = 1; i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
            for(int j=1; j<matrix[0].length;j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(r==0)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][r] = 0;
            }
        }
        if(c == 0)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[c][j] = 0;
            }
        }
        System.gc();
    }
}