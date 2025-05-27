class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        son = (n * (n+1)) // 2
        k = n // m
        k1 = k * (k+1) * m//2
        return son - ( 2 * k1)