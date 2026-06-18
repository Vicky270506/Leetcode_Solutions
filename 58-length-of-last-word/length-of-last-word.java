class Solution {
    public int lengthOfLastWord(String s) {
        int l = 0;
        int ans = 0;
        for(char c: s.toCharArray())
        {
            if(!Character.isWhitespace(c))
            {
                l++;
            }
            else
            {
                ans = l != 0 ? l : ans;
                l = 0;
            }
        }
        ans = l != 0 ? l : ans;
        return ans;
    }
}