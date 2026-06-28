class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        d = collections.Counter(magazine)

        for i in ransomNote:
            if i not in d.keys() or d[i] < 1:
                return False
            d[i] -= 1
        return True