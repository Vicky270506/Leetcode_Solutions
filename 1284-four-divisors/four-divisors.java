class Solution {
    public int sumFourDivisors(int[] nums) {
       int ans = 0;
       Map<Integer,Integer> values = new HashMap<Integer,Integer>();
       for(int i: nums)
       {
        int v = values.getOrDefault(i,-1);
        if(v == -1)
        {
            int t = findDivisor(i);
            values.put(i,t);
            System.out.println("This is for Number "+i);
        } 
        ans+= values.get(i);
       }
       System.out.print(values);
       return ans;
    }
    private static int findDivisor(int n)
    {
        if(n<6)
        {
            return 0;
        }
        else
        {
            int count = 0;
            int s = 0;
            int cond = n/2;
            for(int i = 1; i<= cond;i++)
            {
                if(n%i==0)
                {
                    count++;
                    s+=i;
                }
            }
            if(count==3)
            {
                return s+n;
            }
            else
            {
                return 0;
            }
        }
    }
}