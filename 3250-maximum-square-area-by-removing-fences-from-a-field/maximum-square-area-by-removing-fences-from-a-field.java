class Solution {
    public final int MOD = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hValues = new ArrayList<Integer>();
        hValues.add(1);
        for(int i: hFences)
        {
            hValues.add(i);
        }
        hValues.add(m);
        Set<Integer> sides = findSides(hValues);
        hValues.clear();
        hValues.add(1);
        for(int i: vFences)
        {
            hValues.add(i);
        }
        hValues.add(n);
        return findMaxArea(hValues,sides,-1);
    }
    private Set<Integer> findSides(List<Integer> a)
    {
        Set<Integer> res = new HashSet<Integer>();
        for(int i: a)
        {
            for(int j: a)
            {
                if(i != j)
                {
                    res.add(j-i);
                }
            }
        }
        return res;
    }
    private int findMaxArea(List<Integer> v, Set<Integer> values, long ans)
    {
        int currentMax;
        for(int i: v)
        {
            for(int j: v)
            {
                if(i!=j)
                {
                    currentMax = j-i;
                    if(currentMax>ans && values.contains(currentMax))
                    {
                        ans = currentMax;
                    }
                }
            }
        }
        if(ans!=-1)
        {
            return (int)((ans*ans)%MOD);
        }
        else
        {
            return -1;
        }
    }
}