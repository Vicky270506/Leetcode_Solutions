class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        for(char c : s.toCharArray())
        {
            switch(c)
            {
                case '*':
                    if(length > 0) length--;
                    break;

                case '#':
                    length *= 2;
                    break;
                
                case '%':
                    break;
                
                default:
                    length++;
                    break;
            }
        }
        if(k+1 > length)
        {
            return '.';
        }
        for(int i=s.length()-1; i>=0; i--)
        {
            char c = s.charAt(i);
            switch(c)
            {
                case '*':
                    length += 1;
                    break;
                case '#':
                    long half = (length+1) / 2;
                    if(k+1 > half)
                    {
                        k -= (length/2);
                    }
                    length = half;
                    break;
                case '%':
                    k = length - k - 1;
                    break;
                default:
                    if(k+1 == length)
                    {
                        return c;
                    }
                    length-=1;
                    break;
            }
        }
        return '.';
    }
}