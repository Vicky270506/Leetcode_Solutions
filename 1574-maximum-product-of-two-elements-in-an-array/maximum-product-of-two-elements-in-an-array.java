class Solution {
    public int maxProduct(int[] n) {
        int a = -1;
        int b = -1;

        for(int i: n)
        {
            if(i > a)
            {
                b = a;
                a = i;
            }
            else if(i > b)
            {
                b = i;
            }
        }

        return (a-1) * (b-1);
    }
}