class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int ans = 0;
        int l = 0;
        for(char c : s.toCharArray())
        {
            if(c == '1')
            {
                ans = Math.max(ans, l);
                l = 1;
            }
            else if ( l>0 )
            {
                l++;
            }
        }
        return ans;
    }
}