class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        else if(x >= 0 && x < 10)
        {
            return true;
        }
        else
        {
            int rev = 0, n = x;
            while(x>0)
            {
                int r = x%10;
                rev = (rev*10) + r;
                x/=10;
            }
            return n==rev;
        }
    }
}