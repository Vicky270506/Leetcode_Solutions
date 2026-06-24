class Solution:
    def isHappy(self, n: int) -> bool:
        s = set()
        d = {str(x) : (lambda y: y**2)(x) for x in range(0,10)}

        while n != 1 and n not in s:
            s.add(n)
            v = 0
            for i in str(n):
                v += d[i]
            n = v

        return n == 1