import bisect
from typing import List

class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        max_val = max(nums)
        
        # 1. Count the frequency of each number in the array
        freq = [0] * (max_val + 1)
        for num in nums:
            freq[num] += 1
            
        # 2. exact_gcd[i] will store the EXACT number of pairs whose GCD is i
        exact_gcd = [0] * (max_val + 1)
        
        # 3. Count pairs that share a common divisor 'i'
        for i in range(1, max_val + 1):
            multiples_count = 0
            # Step through all multiples of i (i, 2i, 3i...)
            for j in range(i, max_val + 1, i):
                multiples_count += freq[j]
            
            # The number of pairs that can be formed using these multiples
            exact_gcd[i] = (multiples_count * (multiples_count - 1)) // 2
            
        # 4. Inclusion-Exclusion: Subtract the overcounted multiples
        # We process backwards so larger multiples are fully resolved before smaller ones
        for i in range(max_val, 0, -1):
            for j in range(2 * i, max_val + 1, i):
                exact_gcd[i] -= exact_gcd[j]
                
        # 5. Build a Prefix Sum array so we can instantly find the query bounds
        prefix = [0] * (max_val + 1)
        for i in range(1, max_val + 1):
            prefix[i] = prefix[i - 1] + exact_gcd[i]
            
        # 6. Answer the queries using Binary Search
        ans = []
        for q in queries:
            # Because 'q' is 0-indexed (e.g., q=0 means the 1st element),
            # bisect_right naturally finds the exact index 'i' where the GCD lives.
            idx = bisect.bisect_right(prefix, q)
            ans.append(idx)
            
        return ans