class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int n = height.length;
        int[] prefix = new int[n];
        prefix[0] = height[0];
        int[] suffix = new int[n];
        suffix[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
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
            if(h <= prefix[i] && h <= suffix[i])
            {
                total += (Math.min(prefix[i], suffix[i]) - h);
            }
        }
    
        return total;

    }
}