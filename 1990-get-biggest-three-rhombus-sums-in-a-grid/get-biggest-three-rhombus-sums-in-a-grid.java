import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                set.add(grid[i][j]);
                if(set.size() > 3) set.pollFirst();

                for(int d=1; i+2*d<m && j-d>=0 && j+d<n; d++){

                    int sum = 0;

                    for(int k=0;k<d;k++)
                        sum += grid[i+k][j+k];

                    for(int k=0;k<d;k++)
                        sum += grid[i+d+k][j+d-k];

                    for(int k=0;k<d;k++)
                        sum += grid[i+2*d-k][j-k];

                    for(int k=0;k<d;k++)
                        sum += grid[i+d-k][j-d+k];

                    set.add(sum);

                    if(set.size() > 3)
                        set.pollFirst();
                }
            }
        }

        int size = set.size();
        int[] res = new int[size];

        for(int i=0;i<size;i++)
            res[i] = set.pollLast();

        return res;
    }
}