class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int N = dimensions.length;
        int long_diag = -1, big_area = -1;

        for(int i=0;i<N;i++)
        {
            int w = dimensions[i][0], h = dimensions[i][1];
            
            if((w*w + h*h) > long_diag)
            {
                long_diag = (w*w + h*h);
                big_area = w * h;
            }
            else if((w*w + h*h) == long_diag && big_area < w*h)
            {
                big_area = w * h;
            }
        }
        return big_area;
    }
}