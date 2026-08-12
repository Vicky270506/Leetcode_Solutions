import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            freq.put(current, freq.getOrDefault(current, 0) + 1);
            
            // If the current element's frequency exceeds k, 
            // shrink the window from the left until it's valid again
            while (freq.get(current) > k) {
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                left++;
            }
            
            // Record the maximum valid contiguous subarray length seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}