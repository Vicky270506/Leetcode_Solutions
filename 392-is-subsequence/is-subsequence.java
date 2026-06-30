class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
        {
            return true;
        }
        int a = 0;
        

        for(char c: t.toCharArray())
        {
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