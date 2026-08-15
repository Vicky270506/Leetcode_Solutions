class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasNonZero = false;
        
        // 1. Calculate the total XOR and check if any non-zero element exists
        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }
        
        // 2. Apply our three scenarios
        if (totalXor != 0) {
            // Scenario 1: The whole array is already valid
            return nums.length;
        } else if (hasNonZero) {
            // Scenario 2: Total XOR is 0, so removing exactly one non-zero element fixes it
            return nums.length - 1;
        } else {
            // Scenario 3: The array is nothing but zeros
            return 0;
        }
    }
}