class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Find all indices where nums[i] == key
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        // Step 2: Mark all indices within distance k of each key index
        boolean[] seen = new boolean[nums.length];
        for (int keyIndex : keyIndices) {
            int start = Math.max(0, keyIndex - k);
            int end = Math.min(nums.length - 1, keyIndex + k);
            for (int i = start; i <= end; i++) {
                seen[i] = true;
            }
        }

        // Step 3: Collect all marked indices
        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
