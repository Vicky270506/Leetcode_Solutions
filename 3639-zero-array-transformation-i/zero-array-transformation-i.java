class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int left, right, flag=0;
        int[] diff = new int[nums.length];
        for( int j=0; j<queries.length; j++)
        {
            left=queries[j][0];
            right=queries[j][1];
            diff[left]+=1;
            if(right+1<diff.length)
            {
                diff[right+1]-=1;
            }
        }
        if(diff[0] < nums[0]) return false;
        for( int j=1; j<diff.length; j++)
        {
            diff[j] += diff[j-1];
            if( diff[j]< nums[j])
                return false;
        }
        System.out.print(Arrays.toString(nums) + Arrays.toString(diff));
        return true;
    }
}