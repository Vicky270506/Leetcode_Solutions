class Solution {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    public int reverse(int x) {
        boolean sign = true;
        if(x<0)
        {
            sign = false;
            x = -x;
        }
        int r=0;
        while(x>0)
        {
            if(r > max/10)
            {
                return 0;
            }
            r = (r*10) + (x%10);
            x/=10;
        }
        if(sign)
        {
            return r;
        }
        else
        {
            return -r;
        }
    }
}