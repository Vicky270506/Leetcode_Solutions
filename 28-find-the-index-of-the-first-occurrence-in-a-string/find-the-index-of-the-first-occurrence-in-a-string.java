class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i<haystack.length(); i++)
        {
            if(haystack.charAt(i) == needle.charAt(0))
            {
                if(isThere(haystack, needle, i))
                {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean isThere( String p, String q, int idx)
    {
        for(int i=1;i<q.length();i++)
        {
            if(i + idx >= p.length()) return false;
            if(p.charAt(i + idx) != q.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
}