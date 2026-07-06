class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        Arrays.sort(nums);
        System.out.print(Arrays.toString(nums));
        int ans = 0, cm = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1]+1)
            {
                cm++;
            }
            else if(nums[i] == nums[i-1])
            {
                continue;
            }
            else
            {
                ans = cm > ans ? cm : ans;
                cm = 1;
            }
        }
        return ans > cm ? ans : cm;
    }
}