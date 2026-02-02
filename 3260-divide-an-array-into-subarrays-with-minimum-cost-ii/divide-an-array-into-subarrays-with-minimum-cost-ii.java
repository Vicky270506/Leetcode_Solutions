import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> left = new TreeMap<>();
    private TreeMap<Integer, Integer> right = new TreeMap<>();
    private long currentSum = 0;
    private int leftSize = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int required = k - 1; // We need k-1 more elements after nums[0]
        
        // Initial window: indices [1, dist + 1]
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }
        
        balance(required);
        long minCost = currentSum;

        // Sliding window
        for (int i = dist + 2; i < n; i++) {
            // Remove the element that is sliding out (nums[i - dist - 1])
            remove(nums[i - dist - 1]);
            // Add the new element entering the window
            add(nums[i]);
            // Re-balance to keep exactly 'required' elements in 'left'
            balance(required);
            
            minCost = Math.min(minCost, currentSum);
        }

        return nums[0] + minCost;
    }

    private void add(int val) {
        // Default add to right, balance() will move it if needed
        right.put(val, right.getOrDefault(val, 0) + 1);
    }

    private void remove(int val) {
        if (left.containsKey(val)) {
            int count = left.get(val);
            if (count == 1) left.remove(val);
            else left.put(val, count - 1);
            currentSum -= val;
            leftSize--;
        } else {
            int count = right.get(val);
            if (count == 1) right.remove(val);
            else right.put(val, count - 1);
        }
    }

    private void balance(int targetSize) {
        // 1. Move from right to left if left is too small
        while (leftSize < targetSize && !right.isEmpty()) {
            int first = right.firstKey();
            moveRightToLeft(first);
        }
        
        // 2. Move from left to right if left is too big
        while (leftSize > targetSize) {
            int last = left.lastKey();
            moveLeftToRight(last);
        }
        
        // 3. Ensure all elements in left <= all elements in right
        while (!left.isEmpty() && !right.isEmpty() && left.lastKey() > right.firstKey()) {
            int lMax = left.lastKey();
            int rMin = right.firstKey();
            moveLeftToRight(lMax);
            moveRightToLeft(rMin);
        }
    }

    private void moveRightToLeft(int val) {
        int count = right.get(val);
        if (count == 1) right.remove(val);
        else right.put(val, count - 1);
        
        left.put(val, left.getOrDefault(val, 0) + 1);
        currentSum += val;
        leftSize++;
    }

    private void moveLeftToRight(int val) {
        int count = left.get(val);
        if (count == 1) left.remove(val);
        else left.put(val, count - 1);
        
        right.put(val, right.getOrDefault(val, 0) + 1);
        currentSum -= val;
        leftSize--;
    }
}