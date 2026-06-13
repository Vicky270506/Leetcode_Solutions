class Solution {
    public int count = 0;
    public int divide(int dividend, int divisor) {

        if(divisor == 1)
        {
            return dividend;
        }
        else if(divisor == -1)
        {
            if(dividend == Integer.MIN_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            else
            {
                return -dividend;
            }
        }
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        System.out.print(a);
        System.out.println(" " + b);
        while(a >= b)
        {
            a-=b;
            count++;
        }
        if( dividend < 0 ^ divisor < 0)
        {
            return -count;
        }
        else
        {
            return count;
        }
    }
    private void div(long a, long b)
    {
        if(a < b)
        {
            return;
        }
        count += 1;
        div(a-b,b);
    }
}