class Solution {
    public int jump(int[] nums) {
        int c = 1, next = 0;
        int moves = 0;
        int n = nums.length;

        if(n==1)return 0;

        for(int i=0;i<n;i++)
        {
            c--;
            next--;
            if(next < nums[i])
            {
                next = nums[i];
            }
            if( c == 0 )
            {
                c = next;
                next = 0;
                moves++;
            }
            if((c+i) >= n-1)
            {
                return moves;
            }
            else if((i + nums[i]) >= n-1)
            {
                return moves+1;
            }
        }
        return moves;
    }
}