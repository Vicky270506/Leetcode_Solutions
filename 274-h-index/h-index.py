class Solution:
    def hIndex(self, c: List[int]) -> int:
        m = max(c)

        for i in range(m,0,-1):
            count  = 0
            for j in c:
                if j >= i:
                    count += 1
            if count >= i:
                return i
        return 0