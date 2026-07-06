class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: (x[0], -x[1]))

        ans = 0
        max_end = 0
        for i in intervals:
            start, end = i[0], i[1]

            if end > max_end:
                max_end = end
                ans += 1

        return ans