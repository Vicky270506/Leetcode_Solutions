class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        Stack<Character> s = new Stack<Character>();
        
        for(int i=0;i<directions.length();i++)
        {   
            char d = directions.charAt(i);
            if(!s.empty())
            {
                char c = s.peek();
                if(c == 'S')
                {
                    if(d == 'L')
                    {
                        ans += 1;
                    }
                    else if (d == 'R')
                    {
                        s.pop();
                        s.push(d);
                    }
                }
                else if(c == 'L')
                {
                    if(d == 'S' || d == 'R')
                    {
                        s.pop();
                        s.push(d);
                    }
                }
                else
                {
                    if(d == 'S')
                    {
                        while(!s.empty())
                        {
                            s.pop();
                            ans += 1;
                        }
                        s.push('S');
                    }
                    else if( d == 'L')
                    {
                        ans += 2;
                        s.pop();
                        while(!s.empty())
                        {
                            s.pop();
                            ans += 1;
                        }
                        s.push('S');
                    }
                    else
                    {
                        s.push(d);
                    }
                }
            }
            else
            {
                s.push(d);
            }
        }
        return ans;
    }

}