class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1) return false;
        int val = 1;
        for(int i=0;i<25;i++)
        {
            if(val==n)
            {
                return true;
            }
            val *= 4;
        }
        return false;
    }
}