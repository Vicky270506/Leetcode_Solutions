class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        String ans = "";
        boolean flag = false;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i) == ' ' && flag == true)
            {
                sb.reverse();
                ans += sb.toString();
                ans += " ";
                sb = new StringBuilder("");
                flag = false;
            }
            else
            {
                if(s.charAt(i) != ' ')
                {
                    sb.append(s.charAt(i));
                    flag = true;
                }
            }
        }
        if(!sb.toString().equals("") && !sb.toString().equals(" "))
        {
            ans += sb.reverse().toString();
        }
        return ans.strip();
    }
}