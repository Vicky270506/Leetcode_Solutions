class Solution {
    static 
    {
        for(int i=0;i<500;i++)
            longestConsecutive(new int[]{});
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int ans = 0;
        for (int num : set) {  // iterate over the set, not nums
            if (!set.contains(num - 1)) {
                int len = 1;
                int next = num + 1;
                while (set.contains(next)) {
                    len++;
                    next++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}