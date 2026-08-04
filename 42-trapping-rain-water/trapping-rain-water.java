class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefix = height[0];
        int[] suffix = new int[n];
        suffix[n-1] = height[n-1];

        for(int i=n-2;i>=0;i--)
        {
            suffix[i] = Math.max(suffix[i+1],height[i]);
        }
        //System.out.println(Arrays.toString(prefix));
        //System.out.println(Arrays.toString(suffix));
        int total = 0;
        for(int i=0; i<n;i++)
        {
            int h = height[i];
            if(h <= prefix && h <= suffix[i])
            {
                total += (Math.min(prefix, suffix[i]) - h);
            }
            prefix = prefix > height[i] ? prefix : height[i];
        }
    
        return total;

    }
}