class Solution {
    public boolean checkStrings(String s1, String s2) {
        Map<Character, Integer> odd = new HashMap<Character, Integer>();
        Map<Character, Integer> even = new HashMap<Character, Integer>();

        for(int i=0;i<s1.length();i++)
        {
            if(i%2==0)
            {
                even.put(s1.charAt(i), even.getOrDefault(s1.charAt(i), 0) + 1);
            }
            else
            {
                odd.put(s1.charAt(i), odd.getOrDefault(s1.charAt(i), 0) + 1);
            }
        }

        for(int i=0;i<s2.length();i++)
        {
            if(i%2 == 0)
            {
                if(!even.containsKey(s2.charAt(i)))
                {
                    return false;
                }
                else
                {
                    if(even.get(s2.charAt(i)) == 1)
                    {
                        even.remove(s2.charAt(i));
                    }
                    else
                    {
                        even.put(s2.charAt(i), even.get(s2.charAt(i))-1);
                    }
                }
            }
            else
            {
                if(!odd.containsKey(s2.charAt(i)))
                {
                    return false;
                }
                else
                {
                    if(odd.get(s2.charAt(i)) == 1)
                    {
                        odd.remove(s2.charAt(i));
                    }
                    else
                    {
                        odd.put(s2.charAt(i), odd.get(s2.charAt(i))-1);
                    }
                }
            }
        }
        return true;
    }
}