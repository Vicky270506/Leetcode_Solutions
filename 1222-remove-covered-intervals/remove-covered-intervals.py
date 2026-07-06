class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        ans = intervals
        removal = set()
        for i in intervals:
            l ,r = i[0], i[1]
            for j in intervals:
                p,q = j[0], j[1]
                if (p,q) in removal:
                    continue
                if l==p and r==q:
                    continue
                elif l <= p and q <= r:
                    removal.add((p,q))

        return len(ans)-len(removal)