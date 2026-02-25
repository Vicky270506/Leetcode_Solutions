class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        def popcount(x: int) -> int:
            return x.bit_count()
        
        return sorted(arr, key=lambda x: (popcount(x), x))