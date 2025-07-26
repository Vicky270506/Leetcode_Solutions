class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> Counts = new HashMap<>();

        for (int i : nums) {
            Counts.put(i, Counts.getOrDefault(i, 0) + 1);
        }

        Arrays.sort(nums);
        int max_val = nums[nums.length-1];

        int[] points = new int[max_val+1];
        int[] dp = new int[max_val+1];

        for(int i = 0; i < max_val+1; i++)
        {
            if (Counts.containsKey(i)) {
                points[i] = i * Counts.get(i);
            } else {
                points[i] = 0; // Or handle as appropriate if key not found
            }
        }
        System.out.print(Arrays.toString(points));
        dp[1] = points[1];

        for( int i = 2; i < max_val+1; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2] + points[i]);
            System.out.print(points[i]);
        }
        Arrays.sort(dp);
        System.out.print(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}