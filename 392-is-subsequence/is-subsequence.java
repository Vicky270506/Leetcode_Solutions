class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
        {
            return true;
        }
        int a = 0;
        

        for(int i=0;i<t.length();i++)
        {
            char c = t.charAt(i);
            if(c == s.charAt(a))
            {
                a++;
                if(a == s.length())
                {
                    return true;
                }
            }
        }
        return false;
    }
}