class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i = 1, j = n-2; i < n; i++ , j--) {
            if(nums[i] > prefix[i-1]) {
                prefix[i] = nums[i];
            }
            else {
                prefix[i] = prefix[i-1];
            }
            if(nums[j] < suffix[j+1]) {
                suffix[j] = nums[j];
            }
            else {
                suffix[j] = suffix[j+1];
            }
        }
        //System.out.println(Arrays.toString(prefix));
        //System.out.println(Arrays.toString(suffix));

        for(int i=0;i<n;i++) {
            int v = prefix[i] - suffix[i];
            if ( v <= k) {
                return i;
            }
        }
        return -1;
    }
}