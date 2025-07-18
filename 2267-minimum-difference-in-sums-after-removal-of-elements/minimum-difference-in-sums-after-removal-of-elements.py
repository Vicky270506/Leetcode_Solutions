class Solution(object):
    def minimumDifference(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) // 3

        # left_sums[k] stores the minimum sum of 'n' elements from nums[0...k-1]
        # k ranges from n to 3n.
        left_sums = [float('inf')] * (3 * n + 1)
        
        current_sum_left = 0
        # max_heap_left will store the 'n' smallest elements (as negative values)
        # in the current window.
        max_heap_left = [] 

        for i in range(3 * n):
            val = nums[i]
            heapq.heappush(max_heap_left, -val)
            current_sum_left += val
            
            # If the heap size exceeds n, remove the largest element from the heap.
            # This largest element is the one that is NOT among the n smallest.
            if len(max_heap_left) > n:
                largest_among_smallest = -heapq.heappop(max_heap_left)
                current_sum_left -= largest_among_smallest
            
            # Once we have exactly n elements in the heap, current_sum_left is the sum
            # of the n smallest elements encountered so far up to index i.
            if len(max_heap_left) == n:
                # The split point k corresponds to (i + 1) because nums[0...i] is the prefix
                left_sums[i + 1] = current_sum_left

        # right_sums[k] stores the maximum sum of 'n' elements from nums[k...3n-1]
        # k ranges from 0 to 2n.
        right_sums = [float('-inf')] * (3 * n + 1)
        
        current_sum_right = 0
        # min_heap_right will store the 'n' largest elements (as positive values)
        # in the current window.
        min_heap_right = []

        for i in range(3 * n - 1, -1, -1): # Iterate from right to left
            val = nums[i]
            heapq.heappush(min_heap_right, val)
            current_sum_right += val
            
            # If the heap size exceeds n, remove the smallest element from the heap.
            # This smallest element is the one that is NOT among the n largest.
            if len(min_heap_right) > n:
                smallest_among_largest = heapq.heappop(min_heap_right)
                current_sum_right -= smallest_among_largest
            
            # Once we have exactly n elements in the heap, current_sum_right holds their sum
            if len(min_heap_right) == n:
                # The split point k corresponds to i because nums[i...3n-1] is the suffix
                right_sums[i] = current_sum_right
        
        min_overall_diff = float('inf')

        # Iterate through all possible split points 'k'
        # 'k' is the effective boundary: sumFirst takes n from nums[0...k-1], sumSecond from nums[k...3n-1]
        # Valid k ranges from n to 2n.
        for k in range(n, 2 * n + 1):
            if left_sums[k] != float('inf') and right_sums[k] != float('-inf'):
                current_diff = left_sums[k] - right_sums[k]
                min_overall_diff = min(min_overall_diff, current_diff)
        
        return min_overall_diff



        