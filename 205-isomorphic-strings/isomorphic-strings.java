class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m = new HashMap<>();
        Set<Character> st = new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(!m.containsKey(c))
            {
                if(!st.contains(d))
                {
                    m.put(c,d);
                    st.add(d);
                }
                else
                {
                    return false;
                }
            }
            else if(m.get(c) != d)
            {
                return false;
            }
        }
        return true;
        
    }
}