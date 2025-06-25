class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10_000_000_000L, right = 10_000_000_000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (int num : nums1) {
            count += countPairs(num, nums2, mid);
        }
        return count;
    }

    private long countPairs(int num, int[] nums, long mid) {
        int left = 0, right = nums.length - 1;
        if (num > 0) {
            // Binary search for the largest j such that num * nums[j] <= mid
            while (left <= right) {
                int m = left + (right - left) / 2;
                if ((long) num * nums[m] <= mid) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }
            return left;
        } else if (num < 0) {
            // Binary search for the smallest j such that num * nums[j] <= mid
            while (left <= right) {
                int m = left + (right - left) / 2;
                if ((long) num * nums[m] <= mid) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            }
            return nums.length - left;
        } else {
            // num == 0 → product always 0, so all <= mid if mid >= 0
            return mid >= 0 ? nums.length : 0;
        }
    }
}