import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: one prefix sum of 0 exists before the array starts
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;

            // Check if there is a previous prefix sum such that
            // currentSum - previousSum = k
            ans += map.getOrDefault(sum - k, 0);

            // Store/update the current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.gc();
        return ans;
    }
}