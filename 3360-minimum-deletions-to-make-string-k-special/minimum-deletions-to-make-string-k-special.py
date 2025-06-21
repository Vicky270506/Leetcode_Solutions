class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        chars = set(word)
        freq = {}
        mv = 10 ** 20

        for i in chars:
            freq[i] = word.count(i)
        
        for ch in chars:
            val = 0
            for i, j in freq.items():
                if i == ch:
                    continue
                if j < word.count(ch):
                    val += j
                elif j > word.count(ch) + k:
                    val += j - word.count(ch) - k
            mv = min(mv, val)
        
        return mv

