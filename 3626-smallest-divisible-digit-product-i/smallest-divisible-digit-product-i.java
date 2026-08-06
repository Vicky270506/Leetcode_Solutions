class Solution {
    public int smallestNumber(int n, int t) {
        int d = findProductDigit(n++);
        while(d%t != 0){
            d = findProductDigit(n++);
        }
        return n-1;
    }
    private int findProductDigit(int n){
        int s = 1;
        while(n > 0){
            int r = n % 10;
            s *= r;
            n/=10;
        }
        return s;
    }
}