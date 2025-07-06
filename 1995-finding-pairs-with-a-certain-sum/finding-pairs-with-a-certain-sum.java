import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    int[] nums1;
    int[] nums2; // Add this line to store nums2
    Map<Integer, Integer> countMap; // to store counts of nums2's elements

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2; // initialize nums2
        this.countMap = new HashMap<>();
        for (int num : nums2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        // Decrease the count of the old value
        countMap.put(oldVal, countMap.get(oldVal) - 1);
        int newVal = oldVal + val;
        nums2[index] = newVal;
        // Increase the count for the new value
        countMap.put(newVal, countMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int x : nums1) {
            int need = tot - x;
            res += countMap.getOrDefault(need, 0);
        }
        return res;
    }
}