class Solution {
    public boolean checkOnesSegment(String s) {
        int scount = 0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i) == '0' && s.charAt(i-1) == '1')
            {
                scount++;
            }
            if(i == s.length() -1 && s.charAt(i) == '1')
            {
                scount++;
            }
        }
        if(scount <= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}