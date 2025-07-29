class Solution(object):
    def smallestSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        def calcSubsets(n, nums):
            o = [1] * n  # Initialize result array
            last_bit_pos = [-1] * 32  # Track last position of each bit
            
            # Process backwards through the array
            for i in range(n - 1, -1, -1):
                max_length = 1  # Minimum subarray size is 1
                
                # Check each bit position (0 to 31)
                for bit in range(32):
                    if (nums[i] >> bit) & 1:  # If bit is set in nums[i]
                        last_bit_pos[bit] = i
                    elif last_bit_pos[bit] != -1:  # If bit was seen later
                        # Need to extend subarray to include that bit
                        max_length = max(max_length, last_bit_pos[bit] - i + 1)
                
                o[i] = max_length
            
            return o
        
        N = len(nums)
        return calcSubsets(N, nums)