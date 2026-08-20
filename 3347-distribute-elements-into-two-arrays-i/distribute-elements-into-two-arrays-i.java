class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // arr1 starts from the left
        result[left++] = nums[0];

        // arr2 starts from the right
        result[right--] = nums[1];

        // We need to remember the last elements
        int last1 = nums[0];
        int last2 = nums[1];

        for (int i = 2; i < n; i++) {
            if (last1 > last2) {
                result[left++] = nums[i];
                last1 = nums[i];
            } else {
                result[right--] = nums[i];
                last2 = nums[i];
            }
        }

        // arr2 was built backwards
        int l = right + 1;
        int r = n - 1;

        while (l < r) {
            int temp = result[l];
            result[l] = result[r];
            result[r] = temp;
            l++;
            r--;
        }

        return result;
    }
}