class Solution {
    double r = Math.pow(2,31);
    public int myAtoi(String s) {
        long ans = -1;
        boolean sign = true;
        String p = "-+0123456789 ";
        for(char c: s.toCharArray())
        {
            String temp = String.valueOf(c);
            if(!p.contains(temp))
            {
                break;
            }
            if(ans == -1)
            {
                if(c == '-')
                {
                    sign = false;
                    ans=0;
                    continue;
                }
                else if(c == '+')
                {
                    sign = true;
                    ans=0;
                    continue;
                }
            }
            int v = (int)c;
            if(v < 58 && v > 47)
            {
                if(ans == -1)
                {
                    ans = v-48;
                }
                else
                {
                    if( (ans*10 + (v-48)) > (int)(r) )
                    {
                        if(sign)
                        {
                            return (int)(r-1);
                        }
                        else
                        {
                            return (int)(-r);
                        }
                    }
                    else
                    {
                        ans*=10;
                        ans+=(v-48);
                        System.out.println(ans);
                    }
                }
            }
            else if(ans != -1)
            {
                break;
            }
        }
        if(ans != -1)
        {
            if(!sign)
            {
                ans -= 2*ans;
            }
            return (int)ans;
        }
        else return 0;
    }
}