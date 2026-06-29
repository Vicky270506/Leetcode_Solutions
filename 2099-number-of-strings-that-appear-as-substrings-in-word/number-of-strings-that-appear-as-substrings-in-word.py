class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        count = 0
        for a in patterns:
            if a in word:
                count += 1
        
        return count