class Solution {
    public boolean isPalindrome(String s) {
        List<Character> str = new ArrayList<Character>();
        for(char c: s.toCharArray())
        {
            if(Character.isAlphabetic(c) || Character.isDigit(c))
            {
                str.add(c);
            }
        }
        if(str.size()<2)
        {
            return true;
        }
        else{
            String STR = StringBuilding(str).toLowerCase();
            Collections.reverse(str);
            String revSTR = StringBuilding(str).toLowerCase();
            System.out.println(STR + " " + revSTR);
            if(STR.equals(revSTR))
            {
                return true;
            }
            else{
                return false;
            }
        }
    }
    public String StringBuilding(List<Character> c)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch: c)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
}