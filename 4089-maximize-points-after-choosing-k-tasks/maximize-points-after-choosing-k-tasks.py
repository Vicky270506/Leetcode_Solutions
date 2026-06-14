class Solution:
    def maxPoints(self, t1: List[int], t2: List[int], k: int) -> int:
        n = len(t1)
        k = n - k
        s = sum(t1)

        d = {}
        for i in range(0, n):
            d[i] = t2[i]-t1[i]
        
        d = dict(sorted(d.items(), key=lambda x:x[1], reverse=True))

        for i in d.keys():
            if (s-t1[i]) + t2[i] > s and k > 0:
                k -= 1
                s -= t1[i]
                s += t2[i]
            elif k == 0:
                break
        return s