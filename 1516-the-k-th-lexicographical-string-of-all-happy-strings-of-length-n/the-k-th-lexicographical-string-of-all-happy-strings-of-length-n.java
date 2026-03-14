class Solution {
    List<String> ans = new ArrayList<String>();
    public String getHappyString(int n, int k) {
        if(k > (3 * (int)Math.pow(2,n-1)))
        {
            return "";
        }
        findString("", n);
        return ans.get(k-1);
    }
    private void findString(String s, int n)
    {
        if(s.length() == n)
        {
            ans.add(s);
            return;
        }

        for( char currentChar = 'a'; currentChar <= 'c'; currentChar++)
        {
            if(s.length() > 0 && s.charAt(s.length()-1) == currentChar)
            {
                continue;
            }

            findString(s + currentChar, n);
        }
    }
}