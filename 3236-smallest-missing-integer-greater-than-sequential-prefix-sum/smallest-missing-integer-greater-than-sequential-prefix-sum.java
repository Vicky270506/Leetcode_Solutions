import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        // 1. Calculate the sum of the longest sequential prefix
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // If the sequence continues, add to our sum
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                // The moment it breaks, the prefix is over. 
                break;
            }
        }
        
        // 2. Put all numbers in a HashSet for lightning-fast lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // 3. Find the smallest missing integer that is >= sum
        while (set.contains(sum)) {
            sum++;
        }
        
        return sum;
    }
}