class Solution(object):
    def kthCharacter(self, k, operations):
        """
        Finds the k-th character after applying operations without building the full string.
        Uses mathematical approach to determine character and increment count.
        """
        # Find minimum operations needed
        length = 1
        ops_needed = 0
        
        # Only process operations until we have enough length
        for i, op in enumerate(operations):
            if length >= k:
                break
            length *= 2
            ops_needed = i + 1
        
        # If k is still beyond our reach, return empty string
        if length < k:
            return ""
        
        # Work backwards to find the character
        pos = k - 1  # Convert to 0-based indexing
        increment_count = 0
        
        # Trace back through operations
        for i in range(ops_needed - 1, -1, -1):
            half_length = length // 2
            
            if pos >= half_length:
                # Character is in the second half
                pos -= half_length
                if operations[i] == 1:
                    increment_count += 1
            
            length = half_length
        
        # Calculate final character
        final_char_code = ord('a') + increment_count
        
        # Handle wrap-around if needed (though problem likely doesn't require this)
        if final_char_code > ord('z'):
            final_char_code = ord('a') + (final_char_code - ord('a')) % 26
        
        return chr(final_char_code)