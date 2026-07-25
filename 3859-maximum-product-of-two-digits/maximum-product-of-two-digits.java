class Solution {
    public int maxProduct(int n) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        while(n > 0){
            int r = n%10;
            if(r > a)
            {
                b = a;
                a = r;
            }
            else if(r > b)
            {
                b = r;
            }
            n /= 10;
        }

        return a * b;
    }
}