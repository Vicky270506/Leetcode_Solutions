class Solution {
    List<String> ans;
    int w;
    public List<String> fullJustify(String[] words, int maxWidth) {
        String s = new String("");
        ans = new ArrayList<>();
        this.w = maxWidth;
        int count = 0;

        for(String c: words)
        {
            if(s.length() + c.length() > maxWidth)
            {
                Justify(s, count-1);
                s = "" + c + " ";
                count=1;
            }
            else
            {
                s += (c + " ");
                count++;
            }
        }
        if(!s.equals(""))
        {
            Justify(s, 0);
        }
        return ans;
    }
    private void Justify(String s, int c)
    {
        StringBuilder sb = new StringBuilder();
        if(c!=0)
        {
            int r = (w+1 - s.length())/(c);
            int k = (w+1 - s.length())%(c);
            boolean isAfterWhiteSpace = false;

            for(char ch: s.toCharArray())
            {
                if(isAfterWhiteSpace && !Character.isWhitespace(ch))
                {
                    for(int i=0;i<=r;i++)
                    {
                        sb.append(" ");
                    }
                    isAfterWhiteSpace = false;
                    if(k>0)
                    {
                        sb.append(" ");
                        k--;
                    }
                }
                if(Character.isWhitespace(ch))
                {
                    isAfterWhiteSpace = true;
                }
                else
                {
                    sb.append(ch);
                }
                
            }
        }
        else
        {
            int r = w-s.length();
            for(int i=0;i<s.length();i++)
            {
                if(i<w)
                {
                    sb.append(s.charAt(i));
                }
                else
                {
                    break;
                }
            }
            for(int i=0;i<r;i++)
            {
                sb.append(" ");
            }
        }
        ans.add(sb.toString());
        
    }
}